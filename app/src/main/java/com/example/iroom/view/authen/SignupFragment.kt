package com.example.iroom.view.authen

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.iroom.databinding.FragmentSignupBinding
import com.example.iroom.utils.Resource
import com.example.iroom.view.customer.dialog.LoadingDialog
import com.example.iroom.viewmodel.authen.RegisterViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class SignupFragment : Fragment() {

    private lateinit var _binding: FragmentSignupBinding
    private val binding get() = _binding
    lateinit var authActivity: AuthActivity

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: RegisterViewModel by viewModels {
        viewModelFactory
    }

    private val loadingDialog: LoadingDialog = LoadingDialog.newInstance()

    private var countDownTimer: CountDownTimer =  object : CountDownTimer(300000, 1000) {

        override fun onTick(millisUntilFinished: Long) {
            var minutes = (millisUntilFinished / 1000)  / 60
            var seconds = ((millisUntilFinished / 1000) % 60)
            binding.tvCountDownTime.text = "$minutes : $seconds"
        }

        override fun onFinish() {

        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authActivity = (activity as AuthActivity)
//        binding.btnNext.setOnClickListener {
//            authenActivity.replaceFragment(RegisterFragment.newInstance(), false)
//        }

        binding.btnVerify.setOnClickListener {
            viewModel.sendOtpToEmail(binding.edtPhoneNumber.text.toString(),requireActivity())

        }

        binding.btnNext.setOnClickListener {
            viewModel.verifyPhoneNumberWithCode(binding.edtOtp.text.toString())
        }

        viewModel.senOtp.observe(this@SignupFragment, Observer {
            when (it) {
                is Resource.Loading -> {
                    loadingDialog.show(parentFragmentManager,"")
                }
                is Resource.Error -> {
                    loadingDialog.dismiss()
                }
                is Resource.Success -> {
//                    loadingDialog.dismiss()
                    binding.layoutInputOtp.visibility = View.VISIBLE
                    countDownTimer.start()
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SignupFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}