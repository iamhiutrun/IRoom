package com.example.iroom.view.authen

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.fragment.app.Fragment
import com.example.iroom.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var email : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignupBinding.bind(view)

        binding.btnVerifyEmail.setOnClickListener {
            checkVerify()
        }

        binding.btnNext.setOnClickListener {
            next()
        }
    }

    private fun next() {

    }

    private fun checkVerify() {
        if (checkInfor()) {

        }
    }

    private fun checkInfor(): Boolean {
        email = binding.edtEmail.toString().trim()
        if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.equals(email))
            return true
        else
            return false
    }
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}