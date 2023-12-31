package com.example.homework2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework2.databinding.FragmentCameraBinding
import com.example.homework2.databinding.FragmentProfileBinding

class CameraFragment : Fragment(R.layout.fragment_camera) {
    private var binding : FragmentCameraBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentCameraBinding.bind(view)

        val name = arguments?.getString("ARG_NAME")
        Log.e("CameraFragment", name.orEmpty())
    }
}