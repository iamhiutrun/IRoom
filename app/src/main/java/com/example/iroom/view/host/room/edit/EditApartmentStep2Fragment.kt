package com.example.iroom.view.host.room.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iroom.databinding.FragmentEditApartmentStep2Binding

class EditApartmentStep2Fragment : Fragment() {
    private lateinit var _binding: FragmentEditApartmentStep2Binding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditApartmentStep2Binding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            EditApartmentStep2Fragment().apply {

            }
    }
}