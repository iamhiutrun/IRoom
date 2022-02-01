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
import com.example.iroom.databinding.MessageDialogBinding


class MessageDialog : DialogFragment() {
    lateinit var binding: MessageDialogBinding
    lateinit var message: String
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = MessageDialogBinding.inflate(layoutInflater)
        binding.apply {
            tvMessage.text = message
            btnOk.setOnClickListener {
                dismiss()
            }
        }
        return activity?.let {
            val builder = Dialog(it)
            builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
            builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            builder.setContentView(binding.root)
            builder
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {
        @JvmStatic
        fun newInstance(message: String) =
            MessageDialog().apply {
                this.message = message
            }
    }
}