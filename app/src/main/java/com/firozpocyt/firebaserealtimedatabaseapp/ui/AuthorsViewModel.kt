package com.firozpocyt.firebaserealtimedatabaseapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firozpocyt.firebaserealtimedatabaseapp.data.Author
import com.firozpocyt.firebaserealtimedatabaseapp.data.NODE_AUTHORS
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception

class AuthorsViewModel : ViewModel() {

    private val dbAuthors = FirebaseDatabase.getInstance().getReference(NODE_AUTHORS)

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result

    private val _author = MutableLiveData<List<Author>>()
    val author : LiveData<List<Author>>
        get() = _author

    fun addAuthors(author: Author) {
        author.id = dbAuthors.push().key
        dbAuthors.child(author.id!!).setValue(author)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }
    fun fetchAuthors(){
        dbAuthors.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val authors = mutableListOf<Author>()
                    for (authorSnapshot in snapshot.children){
                        val author = authorSnapshot.getValue(Author::class.java)
                        author?.id = authorSnapshot.key
                        author?.let {   authors.add(it) }
                    }
                    _author.value = authors
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}