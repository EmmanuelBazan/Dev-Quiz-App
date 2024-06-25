package com.bazan.devquiz.presentation.pages.schedule.pages

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.getSystemService
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.MESSAGE_EXTRA
import com.bazan.devquiz.NOTIFICATION_ID
import com.bazan.devquiz.NotificationBroadcast
import com.bazan.devquiz.R
import com.bazan.devquiz.TITLE_EXTRA
import com.bazan.devquiz.databinding.FragmentScheduleScreenBinding
import com.bazan.devquiz.presentation.components.CustomAppBar
import com.bazan.devquiz.presentation.components.CustomInformationDialog
import com.bazan.devquiz.presentation.components.CustomTimePickerDialog
import com.bazan.devquiz.presentation.pages.home.adapters.QuestionReminderListAdapter
import com.bazan.devquiz.presentation.pages.schedule.ScheduleScreenViewModel
import com.bazan.devquiz.presentation.pages.schedule.adapters.DaysOfWeekListAdapter
import com.bazan.devquiz.presentation.pages.schedule.components.WeekDaysSelector
import com.bazan.devquiz.presentation.utils.DateTimeUtils
import java.util.Calendar

class ScheduleScreenFragment : Fragment() {
    private var _binding: FragmentScheduleScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var customAppBar: CustomAppBar
    private lateinit var successDialog: CustomInformationDialog
    private lateinit var weekDaysSelector: WeekDaysSelector

    private val scheduleScreenViewModel: ScheduleScreenViewModel = ScheduleScreenViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScheduleScreenBinding.inflate(inflater, container, false)
        initComponent()
        initListeners()
        return binding.root
    }

    private fun initComponent() {
        val appBarView = binding.root.findViewById<View>(R.id.appBarSchedule)
        customAppBar =
            CustomAppBar(requireContext(), appBarView, "Programa tu pregunta", onGoBackSubmit = {
                findNavController().popBackStack()
            })

        successDialog = CustomInformationDialog(
            onSubmitBtnOkListener = {
                goToHome()
            },
            R.layout.information_dialog_template
        )

        weekDaysSelector =
            WeekDaysSelector(requireContext(), requireActivity(), binding.layoutWeekDays)
    }

    private fun initListeners() {
        binding.btnInitTimePicker.setOnClickListener {
            showTimePickerDialog()
        }

        binding.btnCancelScheduleScreen.setOnClickListener {
            goToHome()
        }

        binding.btnScheduleScheduleScreen.setOnClickListener {
            scheduleScreenViewModel.setNotificationsForSelectedDays(requireContext())
            successDialog.show(parentFragmentManager, "ScheduleSuccessDialog")
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = CustomTimePickerDialog { time ->
            scheduleScreenViewModel.onTimeSelected(time,binding.btnInitTimePicker)
        }
        timePicker.show(parentFragmentManager, "DialogTimePicker")
    }

    private fun goToHome() {
        val action =
            ScheduleScreenFragmentDirections.actionScheduleScreenFragmentToHomeScreenFragment()
        findNavController().navigate(action)
    }
}