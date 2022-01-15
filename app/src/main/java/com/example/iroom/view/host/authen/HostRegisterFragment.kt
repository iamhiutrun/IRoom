package com.example.iroom.view.host.authen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iroom.R
import com.example.iroom.databinding.FragmentHostRegisterBinding

class HostRegisterFragment : Fragment() {

    private lateinit var _binding: FragmentHostRegisterBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHostRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HostRegisterFragment().apply {
            }
    }
}