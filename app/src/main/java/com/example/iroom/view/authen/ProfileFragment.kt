package com.example.iroom.view.authen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.iroom.R
import com.example.iroom.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        setInfo()

        binding.btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun setInfo() {
        TODO("Not yet implemented")
    }

    private fun logout() {
        TODO("Not yet implemented")
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }*/

}