package com.firozpocyt.firebaserealtimedatabaseapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.firozpocyt.firebaserealtimedatabaseapp.databinding.DialogFragmentAddAuthorBinding

class AddAuthorDialogFragment : DialogFragment() {

    private var binding: DialogFragmentAddAuthorBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentAddAuthorBinding.inflate(inflater, container,false)

        return binding!!.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)
    }

}