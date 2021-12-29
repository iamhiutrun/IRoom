package com.example.iroom.view.authen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.iroom.databinding.FragmentLoginBinding
import com.example.iroom.viewmodel.authen.LoginViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var authActivity: AuthActivity

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        authActivity = (activity as AuthActivity)
        binding.btnSignup.setOnClickListener {
            authActivity.replaceFragment(SignupFragment.newInstance(),false)
        }

        binding.btnLogin.setOnClickListener {
            authActivity.navigateToHome()
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