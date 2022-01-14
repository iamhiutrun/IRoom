package com.example.iroom.view.host.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iroom.databinding.FragmentHostNotificationBinding
import com.example.iroom.databinding.FragmentHostRevenueBinding

class HostNotificationFragment : Fragment() {
    private lateinit var _binding: FragmentHostNotificationBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHostNotificationBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HostNotificationFragment().apply {
            }
    }
}