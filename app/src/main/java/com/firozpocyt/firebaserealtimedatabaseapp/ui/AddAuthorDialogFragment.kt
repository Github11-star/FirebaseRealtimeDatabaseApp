package com.firozpocyt.firebaserealtimedatabaseapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.firozpocyt.firebaserealtimedatabaseapp.R
import com.firozpocyt.firebaserealtimedatabaseapp.data.Author
import com.firozpocyt.firebaserealtimedatabaseapp.databinding.DialogFragmentAddAuthorBinding

class AddAuthorDialogFragment : DialogFragment() {

    private var binding: DialogFragmentAddAuthorBinding? = null
    private lateinit var viewModel: AuthorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this)[AuthorsViewModel::class.java]
        binding = DialogFragmentAddAuthorBinding.inflate(inflater, container,false)
        return binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner, Observer {
            val message = if (it == null) {
                getString(R.string.author_added)
            } else {
                getString(R.string.error, it.message)
            }
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            dismiss()
        })

        binding!!.buttonAdd.setOnClickListener {
            val name = binding!!.editTextName.text.toString().trim()
            if (name.isEmpty()){
                binding!!.inputLayoutName.error = getString(R.string.error_field_required)
                return@setOnClickListener
            }
            val author = Author()
            author.name = name
            viewModel.addAuthors(author)
        }
    }

}