package com.example.iroom.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iroom.databinding.FragmentApartmentBinding

class ApartmentFragment : Fragment() {

    private lateinit var _binding: FragmentApartmentBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentApartmentBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ApartmentFragment().apply {

            }
    }
}