package com.example.iroom.view.order

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
import com.example.iroom.databinding.FragmentOrderBinding
import com.example.iroom.model.entity.Order
import com.example.iroom.utils.Resource
import com.example.iroom.view.order.adapter.HeaderViewHolder
import com.example.iroom.view.order.adapter.OrderViewHolder
import com.example.iroom.viewmodel.order.OrderViewModel
import dagger.android.support.AndroidSupportInjection
import smartadapter.SmartRecyclerAdapter
import smartadapter.stickyheader.StickyHeaderItemDecorationExtension
import javax.inject.Inject

class OrderFragment : Fragment() {
    private lateinit var _binding: FragmentOrderBinding
    private val binding get() = _binding

    lateinit var orderAdapter: SmartRecyclerAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: OrderViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewModel()
    }

    private fun initAdapter() {
        orderAdapter = SmartRecyclerAdapter
            .empty()
            .map(Order::class, OrderViewHolder::class)
            .map(String::class, HeaderViewHolder::class)
            .add(
                StickyHeaderItemDecorationExtension(
                    headerItemType = String::class
                )
            )
            .into<SmartRecyclerAdapter>(binding.rvOrders)
    }

    private fun observeViewModel() {
        viewModel.orders.observe(this, {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        Log.d("TAG", "observeViewModel: $data")
                        orderAdapter.setItems(data.toMutableList(), notifyDataSetChanged = true)
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


    companion object {

        @JvmStatic
        fun newInstance() =
            OrderFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}