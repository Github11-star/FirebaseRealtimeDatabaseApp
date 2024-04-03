package com.firozpocyt.firebaserealtimedatabaseapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firozpocyt.firebaserealtimedatabaseapp.databinding.FragmentAuthorsBinding

class AuthorsFragment : Fragment() {

    private var binding: FragmentAuthorsBinding? = null
    private lateinit var viewModel: AuthorsViewModel
    private val adapter = AuthorsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this)[AuthorsViewModel::class.java]
        binding = FragmentAuthorsBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding!!.recyclerViewAuthors.adapter = adapter

        viewModel.fetchAuthors()
        viewModel.author.observe(viewLifecycleOwner, Observer {
            adapter.setAuthors(it)
        })

        binding!!.buttonAdd.setOnClickListener {
            AddAuthorDialogFragment()
                .show(childFragmentManager, "")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}