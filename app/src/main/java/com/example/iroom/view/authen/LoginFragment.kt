package com.example.iroom.view.authen

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.iroom.R
import com.example.iroom.databinding.FragmentLoginBinding
import java.util.regex.Pattern

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var email: String
    private lateinit var password: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            login()
        }

        binding.btnSignup.setOnClickListener {
            signup()
        }

    }

    private fun signup() {
        //
    }

    private fun login() {
        if (checkInfor()) {
            // login
        } else {
            Toast.makeText(context, "err email or password", Toast.LENGTH_SHORT).show()
        }
    }


    fun checkInfor(): Boolean {
        email = binding.edtEmail.text.toString().trim()
        password = binding.edtPassword.text.toString().trim()

        if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.equals(email) && password.isNotEmpty() && password.length >= 6) {
            return true
        } else {
            return false;
        }
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)

    }*/

}