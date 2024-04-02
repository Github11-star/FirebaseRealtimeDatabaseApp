package com.firozpocyt.firebaserealtimedatabaseapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.firozpocyt.firebaserealtimedatabaseapp.databinding.FragmentAuthorsBinding

class AuthorsFragment : Fragment() {

    private var binding: FragmentAuthorsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorsBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding!!.buttonAdd.setOnClickListener {
            AddAuthorDialogFragment()
                .show(childFragmentManager, "")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}