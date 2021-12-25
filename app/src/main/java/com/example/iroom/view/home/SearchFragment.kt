package com.example.iroom.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.iroom.databinding.FragmentSearchBinding
import com.example.iroom.view.base.BaseFragment

class SearchFragment : BaseFragment() {
    private lateinit var _binding: FragmentSearchBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvFilter.setOnClickListener {
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToFilterFragment())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
            }
    }
}