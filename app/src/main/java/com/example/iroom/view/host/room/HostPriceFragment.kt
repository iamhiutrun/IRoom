package com.example.iroom.view.host.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iroom.databinding.FragmentHostPriceBinding

class HostPriceFragment : Fragment() {
    private lateinit var _binding: FragmentHostPriceBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHostPriceBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HostPriceFragment().apply {
            }
    }
}