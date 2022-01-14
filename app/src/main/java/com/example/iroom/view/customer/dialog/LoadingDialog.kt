package com.example.iroom.view.customer.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.graphics.drawable.ColorDrawable
import android.graphics.Color
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import com.example.iroom.R


class LoadingDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val view: View = it.layoutInflater.inflate(
                R.layout.loading_dialog, LinearLayout(
                    activity
                ), false
            )
            val builder = Dialog(it)
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
            builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            builder.setContentView(view)
            builder
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoadingDialog().apply {

            }
    }
}