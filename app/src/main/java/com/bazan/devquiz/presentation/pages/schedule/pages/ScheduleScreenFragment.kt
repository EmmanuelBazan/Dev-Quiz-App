package com.bazan.devquiz.presentation.pages.schedule.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentScheduleScreenBinding
import com.bazan.devquiz.presentation.components.CustomAppBar
import com.bazan.devquiz.presentation.components.CustomInformationDialog
import com.bazan.devquiz.presentation.components.CustomTimePickerDialog
import com.bazan.devquiz.presentation.pages.schedule.viewModel.ScheduleScreenViewModel
import com.bazan.devquiz.presentation.pages.schedule.components.WeekDaysSelector
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleScreenFragment : Fragment() {
    private var _binding: FragmentScheduleScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var customAppBar: CustomAppBar
    private lateinit var successDialog: CustomInformationDialog
    private lateinit var weekDaysSelector: WeekDaysSelector

    val args: ScheduleScreenFragmentArgs by navArgs()

    private val scheduleScreenViewModel: ScheduleScreenViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScheduleScreenBinding.inflate(inflater, container, false)
        initComponent()
        initListeners()
        initObservers()
        scheduleScreenViewModel.getReminderDefaultName()
        scheduleScreenViewModel.getCurrentHour()
        scheduleScreenViewModel.idTechnology = args.idTechnology
        scheduleScreenViewModel.idDifficulty = args.idDifficulty
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
            WeekDaysSelector(
                requireContext(), requireActivity(), binding.layoutWeekDays,
                switchDayToSchedule = {
                    scheduleScreenViewModel.switchDayToSchedule(it)
                },
                scheduleScreenViewModel.daysToSchedule,
            )
    }

    private fun initObservers() {
        scheduleScreenViewModel.mutableName.observe(requireActivity()) {name ->
            binding.inputReminderNameScheduleScreen.setText(name)
        }

        scheduleScreenViewModel.mutableHour.observe(requireActivity()) {hour ->
            binding.btnInitTimePicker.text = hour
        }
    }

    private fun initListeners() {
        binding.btnInitTimePicker.setOnClickListener {
            showTimePickerDialog()
        }

        binding.btnCancelScheduleScreen.setOnClickListener {
            goToHome()
        }

        binding.btnScheduleScheduleScreen.setOnClickListener {
            scheduleScreenViewModel.reminderName = binding.inputReminderNameScheduleScreen.text.toString()
            scheduleScreenViewModel.setNotificationsForSelectedDays(requireContext())
            scheduleScreenViewModel.insertReminder()
            successDialog.show(parentFragmentManager, "ScheduleSuccessDialog")
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = CustomTimePickerDialog { time ->
            scheduleScreenViewModel.onTimeSelected(time, binding.btnInitTimePicker)
        }
        timePicker.show(parentFragmentManager, "DialogTimePicker")
    }

    private fun goToHome() {
        val action =
            ScheduleScreenFragmentDirections.actionScheduleScreenFragmentToHomeScreenFragment()
        findNavController().navigate(action)
    }
}