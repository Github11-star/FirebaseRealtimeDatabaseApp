package com.firozpocyt.firebaserealtimedatabaseapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firozpocyt.firebaserealtimedatabaseapp.data.Author
import com.firozpocyt.firebaserealtimedatabaseapp.data.NODE_AUTHORS
import com.google.firebase.database.FirebaseDatabase
import java.lang.Exception

class AuthorsViewModel : ViewModel() {

    private val _result = MutableLiveData<Exception?>()
            val result : LiveData<Exception?>
                get() = _result

    fun addAuthors(author: Author){
        val dbAuthors = FirebaseDatabase.getInstance().getReference(NODE_AUTHORS)
        author.id = dbAuthors.push().key
        dbAuthors.child(author.id!!).setValue(author)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }
}