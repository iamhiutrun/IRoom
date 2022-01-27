package com.example.iroom.view.customer.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.iroom.databinding.FragmentFilterBinding
import com.example.iroom.model.entity.search.*
import com.example.iroom.view.base.BaseFragment
import com.example.iroom.viewmodel.home.SearchViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FilterFragment : BaseFragment() {
    private lateinit var _binding: FragmentFilterBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SearchViewModel by viewModels {
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
        _binding = FragmentFilterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()
        setOnClick()
        observerData()
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observerData(){
        viewModel.filters.forEach {
            when(it){
                is PriceFilter -> {
                    binding.apply {
                        itemPrice.switchItem.isChecked = true
                        tvMinFigures.setText(it.min)
                        tvMaxFigures.setText(it.max)
                    }
                }

                is Bedroom ->{
                    binding.apply {
                        layoutBedroom.tvCount.text = it.count.toString()
                        itemBedroom.switchItem.isChecked = true
                    }
                }

                is Capacity ->{
                    binding.apply {
                        layoutCapacity.tvCount.text = it.count.toString()
                        itemCapacity.switchItem.isChecked = true
                    }
                }

                is Address ->{
                    binding.apply {
                        itemAddress.switchItem.isChecked = true
                    }
                }

                is AroundYou ->{
                    binding.itemAroundYou.switchItem.isChecked = true
                }
            }
        }
    }

    private fun setOnClick() {
        binding.tvClear.setOnClickListener {
            binding.apply {
                itemAddress.switchItem.isChecked = false
                itemAroundYou.switchItem.isChecked = false
                itemPrice.switchItem.isChecked = false
                itemCapacity.switchItem.isChecked = false
                itemBedroom.switchItem.isChecked = false
                layoutBedroom.tvCount.text = "1"
                layoutCapacity.tvCount.text = "1"
            }
        }
        binding.itemAddress.apply {
            switchItem.setOnCheckedChangeListener { _, b ->
                if (b) binding.itemAroundYou.switchItem.isChecked = false
            }
        }

        binding.itemAroundYou.apply {
            switchItem.setOnCheckedChangeListener { _, b ->
                if (b) binding.itemAddress.switchItem.isChecked = false
            }
        }

        binding.layoutBedroom.apply {
            btnAdd.setOnClickListener {
                tvCount.text = (tvCount.text.toString().toInt() + 1).toString()
            }
            btnMinus.setOnClickListener {
                if (tvCount.text.toString().toInt() > 1)
                    tvCount.text = (tvCount.text.toString().toInt() - 1).toString()
            }
        }

        binding.layoutCapacity.apply {
            btnAdd.setOnClickListener {
                tvCount.text = (tvCount.text.toString().toInt() + 1).toString()
            }
            btnMinus.setOnClickListener {
                if (tvCount.text.toString().toInt() > 1)
                    tvCount.text = (tvCount.text.toString().toInt() - 1).toString()
            }
        }

    }

    private fun bindData() {
        binding.apply {
            itemBedroom.textView.text = "Bedroom"
            itemCapacity.textView.text = "Capacity"
            itemAddress.textView.text = "Address"
            itemAroundYou.textView.text = "Around You"
            //layout bedroom
        }

        binding.btnApply.setOnClickListener {
            var filters = mutableListOf<Any>()
            binding.itemPrice.apply {
                if (switchItem.isChecked) {
                    var priceFilter = PriceFilter(
                        min = binding.tvMinFigures.text.toString(),
                        max = binding.tvMaxFigures.text.toString(),
                    )
                    filters.add(priceFilter)
                }
            }

            binding.itemBedroom.apply {
                if (switchItem.isChecked) {
                    var bedroom = Bedroom(
                        count = binding.layoutBedroom.tvCount.text.toString().toInt()
                    )
                    filters.add(bedroom)
                }
            }

            binding.itemCapacity.apply {
                if (switchItem.isChecked) {
                    var capacity = Capacity(
                        count = binding.layoutCapacity.tvCount.text.toString().toInt()
                    )
                    filters.add(capacity)
                }
            }

            binding.itemAroundYou.apply {
                if (switchItem.isChecked) {
                    var aroundYou = AroundYou()
                    filters.add(aroundYou)
                }
            }

            binding.itemAddress.apply {
                if (switchItem.isChecked) {
                    //TODO: ADD ADDRESS
                }
            }
            viewModel.addFilters(filters)
            findNavController().popBackStack()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FilterFragment().apply {
            }
    }
}