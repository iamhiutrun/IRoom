package com.example.iroom.view.customer.home

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iroom.databinding.FragmentSearchBinding
import com.example.iroom.model.entity.Apartment
import com.example.iroom.utils.Resource
import com.example.iroom.view.base.BaseFragment
import com.example.iroom.view.customer.home.adapter.ApartmentAdapter
import com.example.iroom.viewmodel.home.SearchViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SearchFragment : BaseFragment() {
    private lateinit var _binding: FragmentSearchBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SearchViewModel by viewModels {
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
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnKeywordChange()
        observerData()
        initAdapter()
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvFilter.setOnClickListener {
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToFilterFragment())
        }
    }

    private fun setOnKeywordChange() {
        binding.searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.searchApartmentByKeyword(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun observerData() {
        viewModel.filterCount?.observe(viewLifecycleOwner,{
            binding.tvFilter.text = "Filter ($it)"
        })

        viewModel.apartments?.observe(this, {
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
        apartmentAdapter = ApartmentAdapter(isLarge = true,onClick = apartmentOnClick)
        binding.rvApartment.apply {
            adapter = apartmentAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    var apartmentOnClick : (Apartment) -> Unit = {
        Toast.makeText(context,it.description,Toast.LENGTH_SHORT).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SearchFragment().apply {
            }
    }
}