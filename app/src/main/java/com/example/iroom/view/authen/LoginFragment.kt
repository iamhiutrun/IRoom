package com.example.iroom.view.authen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.iroom.R
import com.example.iroom.databinding.FragmentLoginBinding
import com.example.iroom.utils.Extension.Companion.toast
import com.example.iroom.utils.Resource
import com.example.iroom.view.customer.dialog.LoadingDialog
import com.example.iroom.view.customer.dialog.MessageDialog
import com.example.iroom.view.host.authen.HostRegisterFragment
import com.example.iroom.viewmodel.authen.LoginViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val authActivity: AuthActivity by lazy {
        (activity as AuthActivity)
    }

    private val loadingDialog: LoadingDialog by lazy {
        LoadingDialog.newInstance()
    }

    private val viewModel: LoginViewModel by viewModels {
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
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()
        observeData()
    }

    private fun observeData() {
        viewModel.userInfo.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                    loadingDialog.show(parentFragmentManager, "")
                }
                is Resource.Success -> {
                    loadingDialog.dismiss()
                    authActivity.navigateToHome()
                }
                is Resource.Error -> {
                    if (it.message.toString() == "Email is invalid") {
                        binding.edtEmail.error = it.message.toString()
                    } else {
                        MessageDialog.newInstance(it.message.toString())
                            .show(parentFragmentManager, "")
                    }
                }
            }
        })

        viewModel.userRole.observe(viewLifecycleOwner, {
            when (it) {
                true -> { // role host
                    binding.btnSwitchUser.text =
                        requireContext().resources.getString(R.string.customer)
                }
                else -> { // role customer
                    binding.btnSwitchUser.text = requireContext().resources.getString(R.string.host)
                }
            }
        })
    }

    private fun setOnClick() {
        binding.btnSignup.setOnClickListener {
            if (viewModel.userRole.value!!) {
                authActivity.replaceFragment(HostRegisterFragment.newInstance(), false)
            } else {
                authActivity.replaceFragment(SignupFragment.newInstance(), false)
            }
        }

        binding.btnLogin.setOnClickListener {
            viewModel.login(
                binding.edtEmail.text.toString().trim(),
                binding.edtPassword.text.toString().trim()
            )
        }

        binding.btnSwitchUser.setOnClickListener {
            viewModel.switchRole()
        }

        binding.tvForgotPassword.setOnClickListener {
            "This feature is under development".toast(requireContext())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

}