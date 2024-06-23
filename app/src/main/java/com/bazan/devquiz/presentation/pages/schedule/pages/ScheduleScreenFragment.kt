package com.bazan.devquiz.presentation.pages.schedule.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bazan.devquiz.R
import com.bazan.devquiz.databinding.FragmentScheduleScreenBinding
import com.bazan.devquiz.presentation.components.CustomAppBar
import com.bazan.devquiz.presentation.components.CustomInformationDialog
import com.bazan.devquiz.presentation.components.CustomTimePickerDialog
import com.bazan.devquiz.presentation.pages.schedule.components.WeekDaysSelector
import com.bazan.devquiz.presentation.utils.DateTimeUtils

class ScheduleScreenFragment : Fragment() {
    private var _binding: FragmentScheduleScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var customAppBar: CustomAppBar
    private lateinit var successDialog: CustomInformationDialog
    private lateinit var weekDaysSelector: WeekDaysSelector

    private val dateTimeUtils: DateTimeUtils = DateTimeUtils()

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

        weekDaysSelector = WeekDaysSelector(requireContext(), binding.layoutWeekDays)
    }

    private fun initListeners() {
        binding.btnInitTimePicker.setOnClickListener {
            showTimePickerDialog()
        }

        binding.btnCancelScheduleScreen.setOnClickListener {
            goToHome()
        }

        binding.btnScheduleScheduleScreen.setOnClickListener {
            successDialog.show(parentFragmentManager, "ScheduleSuccessDialog")
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = CustomTimePickerDialog { time ->
            onTimeSelected(time)
        }
        timePicker.show(parentFragmentManager, "DialogTimePicker")
    }

    private fun onTimeSelected(time: String) {
        binding.btnInitTimePicker.text = dateTimeUtils.convertTo12HourFormat(time)
    }

    private fun goToHome() {
        val action =
            ScheduleScreenFragmentDirections.actionScheduleScreenFragmentToHomeScreenFragment()
        findNavController().navigate(action)
    }
}