package com.example.iroom.view.host.revenue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iroom.databinding.FragmentHostRevenueBinding

class HostRevenueFragment : Fragment() {
    private lateinit var _binding: FragmentHostRevenueBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHostRevenueBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HostRevenueFragment().apply {
            }
    }
}