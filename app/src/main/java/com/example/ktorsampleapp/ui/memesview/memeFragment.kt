package com.example.ktorsampleapp.ui.memesview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.ktorsampleapp.R
import com.example.ktorsampleapp.databinding.FragmentMemeListBinding
import com.example.ktorsampleapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class memeFragment : Fragment(R.layout.fragment_meme_list) {
    private lateinit var _binding : FragmentMemeListBinding
    private val binding get() = _binding
    private val viewModel:MemeViewModel by viewModels()
    private val args by navArgs<memeFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMemeListBinding.bind(view)

        setupViews()
    }

    fun setupViews() {
        val adapter = MemeRecyclerViewAdapter()
        Log.d("Direction",args.subR)
        viewModel.address = args.subR
        viewModel.getMemes()
        binding.rvPosts.adapter = adapter
        binding.apply {
            btnTry.setOnClickListener {
                viewModel.getMemes()
            }
        }

        viewModel.memes.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Error -> {
                    binding.apply {
                        layoutErr.visibility = View.VISIBLE
                        bpMeme.visibility = View.GONE
                        tvErr.text = resource.message
                    }
                }
                is Resource.Success -> {
                    binding.apply {
                        layoutErr.visibility = View.GONE
                        bpMeme.visibility = View.GONE
                    }
                    adapter.submitList(resource.data?.memes)
                }
                is Resource.Loading -> {
                    binding.apply {
                        layoutErr.visibility = View.GONE
                        bpMeme.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}