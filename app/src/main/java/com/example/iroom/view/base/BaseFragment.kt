package com.example.iroom.view.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.iroom.MainActivity

open class BaseFragment : Fragment() {

    lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = (activity as MainActivity)
    }

    override fun onResume() {
        super.onResume()
        mainActivity.hideBottomNavBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainActivity.showBottomNavBar()
    }
}