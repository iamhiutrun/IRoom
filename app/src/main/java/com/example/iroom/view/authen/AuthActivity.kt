package com.example.iroom.view.authen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.iroom.view.customer.CustomerActivity
import com.example.iroom.R
import com.example.iroom.view.host.HostActivity


class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authen)
        replaceFragment(LoginFragment.newInstance(), true)
    }

    fun replaceFragment(fragment: Fragment, isTransition: Boolean) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        if (isTransition) {
            fragmentTransition.setCustomAnimations(
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left
            )
        }
        fragmentTransition.replace(R.id.frame_layout, fragment)
            .addToBackStack(fragment.javaClass.simpleName)
        fragmentTransition.commit()
    }


    fun addFragment(fragment: Fragment, isTransition: Boolean) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        if (isTransition) {
            fragmentTransition.setCustomAnimations(
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left
            )
        }
        fragmentTransition.add(R.id.frame_layout, fragment, null)
            .addToBackStack(fragment.javaClass.simpleName)
        fragmentTransition.commit()
    }

    fun navigateToHome() {
        Intent(this@AuthActivity, HostActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(this)
        }
    }

//    fun popTo(tag: String, isTransition: Boolean) {
//        val fragmentTransition = supportFragmentManager.beginTransaction()
//        if (isTransition) {
//            fragmentTransition.setCustomAnimations(
//                android.R.anim.slide_out_right,
//                android.R.anim.slide_in_left
//            )
//        }
//        fragmentTransition.add(R.id.frame_layout, fragment, null)
//            .addToBackStack(fragment.javaClass.simpleName)
//        fragmentTransition.commit()
//    }

}