package com.example.iroom.view.host.room.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iroom.databinding.FragmentEditApartmentStep1Binding

class EditApartmentStep1Fragment : Fragment() {
    private lateinit var _binding: FragmentEditApartmentStep1Binding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditApartmentStep1Binding.inflate(layoutInflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            EditApartmentStep1Fragment().apply {

            }
    }
}