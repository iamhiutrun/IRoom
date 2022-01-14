package com.example.iroom.view.customer.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.iroom.view.customer.CustomerActivity
import com.example.iroom.databinding.FragmentProfileBinding
import com.example.iroom.model.entity.User
import com.example.iroom.utils.Resource
import com.example.iroom.viewmodel.profile.ProfileViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ProfileFragment : Fragment() {

    private lateinit var _binding: FragmentProfileBinding
    private val binding get() = _binding
    lateinit var customerActivity: CustomerActivity

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ProfileViewModel by viewModels {
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
        _binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        customerActivity = (activity as CustomerActivity)
        binding.btnLogout.setOnClickListener {
            customerActivity.navigateToLogin()
        }
        init()
        observeData()
    }

    private fun init() {
        binding.layoutEmail.tvInfoTitle.text = "Email"
        binding.layoutPhoneNumber.tvInfoTitle.text = "Phone Number"
        binding.layoutDateOfBirth.tvInfoTitle.text = "Date of Birth"
        binding.layoutAddress.tvInfoTitle.text = "Address"
        binding.layoutGender.tvInfoTitle.text = "Gender"
    }

    private fun observeData() {
        viewModel.userInfo.observe(this,{ response ->
            when(response){
                is Resource.Success ->{
                    response.data?.let{
                        bindInfo(user = it)
                    }
                }

                is Resource.Loading ->{

                }

                is Resource.Error ->{

                }
            }
        })
    }

    private fun bindInfo(user: User){
        binding.tvFullName.text = user.fullName
        binding.layoutEmail.tvInfo.text = user.email
        binding.layoutPhoneNumber.tvInfo.text = user.phoneNumber
        binding.layoutDateOfBirth.tvInfo.text = user.birthday
        binding.layoutAddress.tvInfo.text = user.address
        binding.layoutGender.tvInfo.text = user.gender.name
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}