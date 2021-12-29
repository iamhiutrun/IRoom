package com.example.iroom.view.authen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iroom.databinding.FragmentRegisterBinding
import com.example.iroom.model.entity.User

class RegisterFragment : Fragment() {

    private lateinit var _binding: FragmentRegisterBinding
    private val binding get() = _binding
    lateinit var authActivity: AuthActivity
    lateinit var userInfo: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authActivity = (activity as AuthActivity)
        binding.btnRegister.setOnClickListener {
            authActivity.replaceFragment(LoginFragment.newInstance(), false)
        }


    }

//    private fun getData(): User {
//        if (binding.layoutConfirmPassword.edtInfo.text.toString()
//            == binding.layoutPassword.edtInfo.text.toString()
//        ) {
//            return User(
//                id = null,
//                fullName = binding.layoutFullName.edtInfo.text.toString(),
//                phoneNumber = binding.layoutPhoneNumber.edtInfo.text.toString(),
//                birthday = binding.layoutBirthday.edtInfo.text.toString(),
//                gender = binding.layoutGender.edtInfo.text.toString(),
//                address = binding.layoutAddress.edtInfo.text.toString(),
//                password = binding.layoutPassword.edtInfo.text.toString(),
//                accessToken = null
//            )
//        }else{
//
//        }

//    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

}