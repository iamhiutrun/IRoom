package com.example.iroom.view.customer.home

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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.FragmentApartmentBinding
import com.example.iroom.model.entity.Apartment
import com.example.iroom.utils.Resource
import com.example.iroom.view.customer.home.adapter.ApartmentAdapter
import com.example.iroom.view.customer.home.adapter.ConvenientAdapter
import com.example.iroom.view.customer.home.adapter.FeedbackAdapter
import com.example.iroom.view.customer.home.adapter.PriceAdapter
import com.example.iroom.viewmodel.home.ApartmentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ApartmentFragment : Fragment() {

    private lateinit var _binding: FragmentApartmentBinding
    private val binding get() = _binding
    val args: ApartmentFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ApartmentViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var apartmentAdapter: ApartmentAdapter
    private lateinit var feedbackAdapter: FeedbackAdapter
    private lateinit var convenientAdapter: ConvenientAdapter
    private lateinit var specialPriceAdapter: PriceAdapter
    private lateinit var normalPriceAdapter: PriceAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentApartmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchApartmentDetail(args.apartment.apartmentId)
        viewModel.fetchSuggestionApartments(args.apartment.apartmentId)
        viewModel.fetchFeedbacks(args.apartment.apartmentId)
        initAdapter()
        bindData()
        setOnClick()
    }

    private fun setOnClick(){
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindData() {
        viewModel.apartmentDetail.observe(this, { response ->
            when (response) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    response.data?.let {
                        binding.apply {
                            layoutApartment.apply {
                                tvApartmentDescription.text = it.description
                                tvAddress.text = it.address
                                binding.tvFigures.text = context.getString(R.string.figures)
                                    .format(it.guest, it.bedroom, it.bath)
                                Glide.with(context).load(it.apartmentUrl)
                                    .error(R.drawable.circle_shape)
                                    .placeholder(R.drawable.circle_shape)
                                    .into(imApartment)

                                Glide.with(context).load(it.viewUrl)
                                    .error(R.drawable.circle_shape)
                                    .placeholder(R.drawable.circle_shape)
                                    .into(imCity)
                            }

                            tvDetailText.text = it.detail

                            layoutHost.apply {
                                Glide.with(context).load(it.host.avatar)
                                    .error(R.drawable.circle_shape)
                                    .placeholder(R.drawable.circle_shape)
                                    .into(imAvatar)
                                tvHostName.text = it.host.fullName
                                tvApartmentCount.text = context.getString(R.string.apartment_count)
                                    .format(it.host.apartmentCount)
                            }

                            convenientAdapter.setData(it.convenient)
                            specialPriceAdapter.setData(it.specialPrice)
                            normalPriceAdapter.setData(it.price)
                        }
                    }
                }
                is Resource.Error -> {

                }
            }
        })

        viewModel.suggestionApartments.observe(this, { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { data ->
                        Log.d("TAG", "observeViewModel: $data")
                        apartmentAdapter.setData(data)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Toast.makeText(context, "An error occured: $message", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                is Resource.Loading -> {

                }
            }
        })

        viewModel.feedbacks.observe(this, { response ->
            when (response) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    response.data?.let { data ->
                        Log.d("TAG", "observeViewModel: $data")
                        feedbackAdapter.setData(data)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Toast.makeText(context, "An error occured: $message", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        })
    }

    private fun initAdapter() {
        apartmentAdapter = ApartmentAdapter(onClick = apartmentOnClick)
        binding.rvSuggestion.apply {
            adapter = apartmentAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        feedbackAdapter = FeedbackAdapter()
        binding.rvFeedback.apply {
            adapter = feedbackAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        convenientAdapter = ConvenientAdapter()
        binding.rvConvenient.apply {
            adapter = convenientAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }

        specialPriceAdapter = PriceAdapter()
        binding.rvSpecialPrice.apply {
            adapter = specialPriceAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        normalPriceAdapter = PriceAdapter()
        binding.rvNormalPrice.apply {
            adapter = normalPriceAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }


    }

    var apartmentOnClick: (Apartment) -> Unit = {
        Toast.makeText(context, it.description, Toast.LENGTH_SHORT).show()
        findNavController().navigate(ApartmentFragmentDirections.actionApartmentFragmentSelf(it))
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            ApartmentFragment().apply {

            }
    }
}