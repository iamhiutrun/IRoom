package com.example.iroom.view.authen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iroom.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    private lateinit var _binding: FragmentSignupBinding
    private val binding get() = _binding
    lateinit var authenActivity: AuthenActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authenActivity = (activity as AuthenActivity)
        binding.btnNext.setOnClickListener {
            authenActivity.replaceFragment(RegisterFragment.newInstance(), false)
        }
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