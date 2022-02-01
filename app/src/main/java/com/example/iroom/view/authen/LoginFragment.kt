package com.example.iroom.view.authen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.iroom.databinding.FragmentLoginBinding
import com.example.iroom.utils.Resource
import com.example.iroom.view.customer.dialog.LoadingDialog
import com.example.iroom.view.customer.dialog.MessageDialog
import com.example.iroom.viewmodel.authen.LoginViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var authActivity: AuthActivity

    private lateinit var loadingDialog: LoadingDialog
    private lateinit var messageDialog: MessageDialog

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
        authActivity = (activity as AuthActivity)
        binding.btnSignup.setOnClickListener {
            authActivity.replaceFragment(SignupFragment.newInstance(), false)
        }

        binding.btnLogin.setOnClickListener {
            viewModel.login(
                binding.edtEmail.text.toString().trim(),
                binding.edtPassword.text.toString().trim()
            )
        }
        loadingDialog = LoadingDialog.newInstance()

        viewModel.userInfo.observe(this, {
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
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }else{
                        MessageDialog.newInstance(it.message.toString()).show(parentFragmentManager,"")
                    }
                }
            }
        })
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