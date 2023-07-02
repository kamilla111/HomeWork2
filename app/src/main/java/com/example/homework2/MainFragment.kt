package com.example.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework2.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

//        binding?.run{
//            btnToSettings.setOnClickListener {
//                findNavController().navigate(R.id.action_mainFragment_to_settingragment) }
//
//            btnToProfile.setOnClickListener {
//                findNavController().navigate(
//                    R.id.action_mainFragment_to_profileFragment,
//                    ProfileFragment.createBundle("Jovany", 33)
//                )
//            }
//        }
        }
//
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}