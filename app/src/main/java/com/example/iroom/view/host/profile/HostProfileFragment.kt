package com.example.iroom.view.host.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iroom.databinding.FragmentHostProfileSBinding
import com.example.iroom.databinding.FragmentHostRevenueBinding

class HostProfileFragment : Fragment() {
    private lateinit var _binding: FragmentHostProfileSBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHostProfileSBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HostProfileFragment().apply {
            }
    }
}