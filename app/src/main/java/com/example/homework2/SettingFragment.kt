package com.example.homework2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework2.databinding.FragmentProfileBinding
import com.example.homework2.databinding.FragmentSettingBinding

class SettingFragment : Fragment(R.layout.fragment_setting) {
    private var binding : FragmentSettingBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentSettingBinding.bind(view)

        val name = arguments?.getString("ARG_NAME")
        Log.e("SettingFragment", name.orEmpty())
    }
}