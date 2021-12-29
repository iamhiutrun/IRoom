package com.example.iroom.view.collection

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iroom.databinding.FragmentCollectionBinding
import com.example.iroom.utils.Resource
import com.example.iroom.view.home.HomeFragmentDirections
import com.example.iroom.view.home.adapter.ApartmentAdapter
import com.example.iroom.view.home.adapter.ChipAdapter
import com.example.iroom.view.home.adapter.CityAdapter
import com.example.iroom.viewmodel.authen.LoginViewModel
import com.example.iroom.viewmodel.collection.CollectionViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CollectionFragment : Fragment() {
    private lateinit var _binding: FragmentCollectionBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CollectionViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var apartmentAdapter: ApartmentAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCollectionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.apartments.observe(this, {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        Log.d("TAG", "observeViewModel: $data")
                        apartmentAdapter.setData(data)
                    }
                }
                is Resource.Error -> {
                    it.message?.let { message ->
                        Toast.makeText(context, "An error occured: $message", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                is Resource.Loading -> {

                }
            }
        })
    }

    private fun initAdapter() {
        apartmentAdapter = ApartmentAdapter(isLarge = true)
        binding.rvCollections.apply {
            adapter = apartmentAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CollectionFragment().apply {

            }
    }
}