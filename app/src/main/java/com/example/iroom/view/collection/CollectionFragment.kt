package com.example.iroom.view.collection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iroom.databinding.FragmentCollectionBinding

class CollectionFragment : Fragment() {
    private lateinit var _binding: FragmentCollectionBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCollectionBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CollectionFragment().apply {

            }
    }
}