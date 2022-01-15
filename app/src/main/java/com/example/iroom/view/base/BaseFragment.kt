package com.example.iroom.view.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.iroom.view.customer.CustomerActivity

open class BaseFragment : Fragment() {

    lateinit var customerActivity: CustomerActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customerActivity = (activity as CustomerActivity)
    }

    override fun onResume() {
        super.onResume()
        customerActivity.hideBottomNavBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        customerActivity.showBottomNavBar()
    }
}