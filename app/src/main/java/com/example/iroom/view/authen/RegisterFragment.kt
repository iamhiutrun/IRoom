package com.example.iroom.view.authen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.iroom.R
import com.example.iroom.databinding.FragmentRegisterBinding
import com.example.iroom.model.entity.Gender
import com.example.iroom.model.entity.User
import com.example.iroom.model.entity.register.SignUpReqDTO
import com.example.iroom.model.entity.register.UserRole

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
//            authActivity.replaceFragment(LoginFragment.newInstance(), false)
            //TODO: ACHIEVE DATA
            SignUpReqDTO(
                fullName = binding.layoutFullName.edtInfo.text.toString().trim(),
                dateOfBirth = binding.layoutBirthday.edtInfo.text.toString().trim(),
                email = binding.layoutEmail.edtInfo.text.toString().trim(),
                gender = when (binding.layoutGender.spinnerGender.selectedItemPosition) {
                    0 -> {
                        Gender.Male
                    }
                    1 -> {
                        Gender.Female
                    }
                    2 -> {
                        Gender.Others
                    }
                    else -> {
                        Gender.Others
                    }
                },
                address = binding.layoutAddress.edtInfo.text.toString(),
                userRole = UserRole.ROLE_USER
            )
        }
        bindData()

        binding.layoutGender.apply {

        }
    }

    private fun bindData() {
        binding.apply {
            layoutEmail.apply {
                tvInfo.text = activity?.getString(R.string.email)
                edtInfo.hint = activity?.getString(R.string.email)
            }

            layoutBirthday.apply {
                tvInfo.text = activity?.getString(R.string.birthday)
                edtInfo.hint = activity?.getString(R.string.birthday)
            }

            layoutGender.apply {
                tvInfo.text = activity?.getString(R.string.gender)
                edtInfo.visibility = View.GONE
                spinnerGender.apply {
                    visibility = View.VISIBLE
                    adapter = ArrayAdapter(
                        requireContext(),
                        R.layout.item_dropdown,
                        resources.getStringArray(R.array.gender_menu)
                    )
                }
            }

            layoutAddress.apply {
                tvInfo.text = activity?.getString(R.string.address)
                edtInfo.hint = activity?.getString(R.string.address)
            }

            layoutPassword.apply {
                tvInfo.text = activity?.getString(R.string.password)
                edtInfo.hint = activity?.getString(R.string.password)
            }

            layoutConfirmPassword.apply {
                tvInfo.text = activity?.getString(R.string.confirm_password)
                edtInfo.hint = activity?.getString(R.string.password)
            }
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