package com.example.iroom.view.authen

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iroom.R
import com.example.iroom.databinding.FragmentProfileBinding
import com.example.iroom.databinding.FragmentRegisterBinding
import java.time.DayOfWeek
import java.time.MonthDay

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var firstName: String
    private lateinit var phoneNumber: String
    // chua biet lam
    //private lateinit var birthDay: DayOfWeek

    private lateinit var gender: String
    private lateinit var address: String
    private lateinit var pass: String
    private lateinit var confirmPass: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        binding.btnRegister.setOnClickListener {
            if (checkInfor()) {

            }
        }
    }

    private fun checkInfor(): Boolean {
        getInfor()
        if (firstName.isNotEmpty()) else return false

        if (phoneNumber.length == 10 && Patterns.PHONE.equals(phoneNumber)) else return false

        // kt ngay thang if{}

        if (gender.equals("male") || gender.equals("female")) else return false

        if (address.isNotEmpty()) else return false

        if (pass.isNotEmpty() && pass.length >= 6 && pass.equals(confirmPass)) else return false

        return true
    }

    private fun getInfor() {
        firstName = binding.edtFirstName.text.toString().trim()
        phoneNumber = binding.edtPhoneNumber.text.toString().trim()

        //birthDay = binding.edtBirthDay

        gender = binding.edtGender.text.toString().trim()
        address = binding.edtAddress.text.toString().trim()
        pass = binding.edtPassword.text.toString().trim()
        confirmPass = binding.edtConfirmPassword.text.toString().trim()
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }*/

}