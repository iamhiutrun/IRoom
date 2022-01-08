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
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.iroom.R
import com.example.iroom.databinding.FragmentPaymentBinding
import com.example.iroom.model.entity.Payment
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.order.PaymentViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PaymentFragment : Fragment() {
    private lateinit var _binding: FragmentPaymentBinding
    private val binding get() = _binding

    private val args : PaymentFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PaymentViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchOrders(args.orderId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        setOnClick()
    }

    private fun setOnClick(){
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeViewModel() {
        viewModel.payment.observe(this,{
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        Log.d("TAG", "observeViewModel: $data")
                        bindData(it.data)
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

    private fun bindData(payment: Payment){
        binding.apply {
            tvOrderId.text = args.orderId
            tvBankAccount.text = payment.hostPayment.bankAccount
            tvBank.text = payment.hostPayment.bankName
            tvHostName.text = payment.hostPayment.fullName
            tvPrice.text = payment.price
            tvTransactionId.text = payment.transactionId

            Glide.with(requireContext()).load(payment.hostPayment.avatar)
                .error(R.drawable.circle_shape)
                .placeholder(R.drawable.circle_shape)
                .into(imHost)
        }
    }

    companion object {
        fun newInstance() =
            PaymentFragment().apply {
            }
    }
}