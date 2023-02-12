package com.example.ktorsampleapp.ui.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ktorsampleapp.R
import com.example.ktorsampleapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var _binding : FragmentHomeBinding
    val binding get() = _binding
//    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        binding.apply {
            darkSouls.setOnClickListener{
                val action = HomeFragmentDirections.actionHomeFragmentToMemeFragment("d")
                findNavController().navigate(action)
            }
            funnyAnimals.setOnClickListener{
                val action = HomeFragmentDirections.actionHomeFragmentToMemeFragment("a")
                findNavController().navigate(action)
            }
            wholesome.setOnClickListener{
                val action = HomeFragmentDirections.actionHomeFragmentToMemeFragment("w")
                findNavController().navigate(action)
            }
        }
    }
}