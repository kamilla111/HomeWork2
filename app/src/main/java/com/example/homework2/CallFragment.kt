package com.example.homework2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework2.databinding.FragmentCallBinding
import com.example.homework2.databinding.FragmentProfileBinding

class CallFragment : Fragment(R.layout.fragment_call) {
    private var binding : FragmentCallBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentCallBinding.bind(view)

        val name = arguments?.getString("ARG_NAME")
        Log.e("CallFragment", name.orEmpty())
    }
}