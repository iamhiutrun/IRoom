package com.example.iroom.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.iroom.databinding.FragmentFilterBinding
import com.example.iroom.view.base.BaseFragment

class FilterFragment : BaseFragment() {
    private lateinit var _binding: FragmentFilterBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFilterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            FilterFragment().apply {
            }
    }
}