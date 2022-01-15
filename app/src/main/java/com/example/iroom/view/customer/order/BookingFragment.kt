package com.example.iroom.view.customer.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.iroom.databinding.FragmentBookingBinding
import com.savvi.rangedatepicker.CalendarPickerView
import java.text.SimpleDateFormat
import java.util.*

class BookingFragment : Fragment() {
    private lateinit var _binding: FragmentBookingBinding
    private val binding get() = _binding
    var simpleDateFormat = SimpleDateFormat("dd/MM/yyyy",Locale.getDefault())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCalendar()
        setOnClick()
    }

    private fun setOnClick(){
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(BookingFragmentDirections.actionBookingFragmentToPaymentFragment(orderId = "123"))
        }
    }

    private fun initCalendar(){
        var nextYear = Calendar.getInstance()
        nextYear.add(Calendar.YEAR, 10)
        var lastYear = Calendar.getInstance()
        lastYear.add(Calendar.YEAR, -10)
        binding.calendar.init(lastYear.time, nextYear.time, SimpleDateFormat("MMMM yyyy", Locale.getDefault())) //
            .inMode(CalendarPickerView.SelectionMode.RANGE)
            .withSelectedDate(Date())
            binding.calendar.setOnDateSelectedListener(object:CalendarPickerView.OnDateSelectedListener{
                override fun onDateSelected(date: Date?) {
                    bindSelectedDate()
                }

                override fun onDateUnselected(date: Date?) {

                }

            })
    }
    private fun bindSelectedDate(){
        var selectedDates = binding.calendar.selectedDates
            var selectedDateString = arrayOf(selectedDates[0],selectedDates[selectedDates.lastIndex]).map {
                simpleDateFormat.format(it)
            }
        binding.apply {
            tvTimeCheckIn.text = selectedDateString[0]
            tvTimeCheckOut.text = selectedDateString[1]
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BookingFragment().apply {
            }
    }
}