package com.firozpocyt.firebaserealtimedatabaseapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firozpocyt.firebaserealtimedatabaseapp.R
import com.firozpocyt.firebaserealtimedatabaseapp.data.Author
import com.firozpocyt.firebaserealtimedatabaseapp.databinding.RecyclerViewAuthorBinding

class AuthorsAdapter: RecyclerView.Adapter<AuthorsAdapter.AuthorViewModel>() {

    private var authors = mutableListOf<Author>()
    //private lateinit var binding: RecyclerViewAuthorBinding

    inner class AuthorViewModel(val binding: RecyclerViewAuthorBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AuthorViewModel(
        binding = RecyclerViewAuthorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun setAuthors(authors: List<Author>) {
        this.authors = authors as MutableList<Author>
        notifyDataSetChanged()
    }

    /*fun addAuthor(author: Author) {
        if (!authors.contains(author)) {
            authors.add(author)
        } else {
            val index = authors.indexOf(author)
            if (author.isDeleted) {
                authors.removeAt(index)
            } else {
                authors[index] = author
            }
        }
        notifyDataSetChanged()
    }*/

    override fun getItemCount() = authors.size

    override fun onBindViewHolder(holder: AuthorViewModel, position: Int) {
        holder.binding.textViewName.text = authors[position].name
    }

}