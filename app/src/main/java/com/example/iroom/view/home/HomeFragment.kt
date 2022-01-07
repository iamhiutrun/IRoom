package com.example.iroom.view.home

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
import com.example.iroom.databinding.FragmentHomeBinding
import com.example.iroom.model.entity.Apartment
import com.example.iroom.utils.Resource
import com.example.iroom.view.home.adapter.ApartmentAdapter
import com.example.iroom.view.home.adapter.ChipAdapter
import com.example.iroom.view.home.adapter.CityAdapter
import com.example.iroom.viewmodel.home.HomeViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var cityAdapter: CityAdapter
    private lateinit var apartmentAdapter: ApartmentAdapter
    private lateinit var chipAdapter: ChipAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewModel()
        setNavigation()
    }

    private fun observeViewModel() {
        viewModel.cities.observe(this, {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        Log.d("TAG", "observeViewModel: $data")
                        cityAdapter.setData(data)
                        chipAdapter.setData(data)
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
        cityAdapter = CityAdapter()
        binding.rvCircleCity.apply {
            adapter = cityAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        chipAdapter = ChipAdapter()
        binding.rvCityChip.apply {
            adapter = chipAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        apartmentAdapter = ApartmentAdapter(onClick = apartmentOnClick)
        binding.rvApartment.apply {
            adapter = apartmentAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }
    }

    private fun setNavigation() {
        binding.searchView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
        }
    }

    var apartmentOnClick : (Apartment) -> Unit = {
        Toast.makeText(context,it.description,Toast.LENGTH_SHORT).show()
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToApartmentFragment(it))
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}