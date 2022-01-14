package com.example.iroom.view.notification

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iroom.databinding.FragmentNotificationBinding
import com.example.iroom.model.entity.Notification
import com.example.iroom.utils.Resource
import com.example.iroom.view.notification.adapter.NotificationAdapter
import com.example.iroom.viewmodel.notification.NotificationViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NotificationFragment : Fragment() {
    private lateinit var _binding: FragmentNotificationBinding
    private val binding get() = _binding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: NotificationViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var notificationAdapter: NotificationAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.notifications.observe(this, {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        notificationAdapter.setData(data as MutableList<Notification>)
                    }
                }
                is Resource.Error -> {
                    it.message?.let { message ->
                        Toast.makeText(context, "An error occured: $message", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                is Resource.Loading -> {

                }
            }
        })
    }

    private val onNotificationClick: (Notification)->Unit = {
        Toast.makeText(context,"Notification clicked",Toast.LENGTH_SHORT).show()
    }

    private fun initAdapter() {
        notificationAdapter = NotificationAdapter(onNotificationClick)
        binding.rvNotification.apply {
            adapter = notificationAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NotificationFragment().apply {

            }
    }
}