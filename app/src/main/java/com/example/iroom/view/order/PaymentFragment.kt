package com.example.iroom.view.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iroom.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {
    private lateinit var _binding: FragmentPaymentBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        fun newInstance() =
            PaymentFragment().apply {
            }
    }
}