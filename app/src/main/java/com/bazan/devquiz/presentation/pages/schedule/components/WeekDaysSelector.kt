package com.bazan.devquiz.presentation.pages.schedule.components

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.bazan.devquiz.R
import com.bazan.devquiz.presentation.pages.schedule.ScheduleScreenViewModel

class WeekDaysSelector(
    private val context: Context,
    private val activity: FragmentActivity,
    private val root: View
) {
    private lateinit var btnMonday: Button
    private lateinit var btnTuesday: Button
    private lateinit var btnWenesday: Button
    private lateinit var btnThursday: Button
    private lateinit var btnFriday: Button
    private lateinit var btnSaturday: Button
    private lateinit var btnSunday: Button

    private val scheduleScreenViewModel: ScheduleScreenViewModel = ScheduleScreenViewModel()

    init {
        initComponents()
        initListeners()
        initObservers()
    }

    private fun initComponents() {
        btnMonday = root.findViewById(R.id.btnMonday)
        btnTuesday = root.findViewById(R.id.btnTuesday)
        btnWenesday = root.findViewById(R.id.btnWenesday)
        btnThursday = root.findViewById(R.id.btnThursday)
        btnFriday = root.findViewById(R.id.btnFriday)
        btnSaturday = root.findViewById(R.id.btnSaturday)
        btnSunday = root.findViewById(R.id.btnSunday)
    }

    private fun initObservers() {
        scheduleScreenViewModel.daysToSchedule.observe(activity) { days ->
            for (i in days.indices) {
                when (i) {
                    0 -> {
                        switchButtonStyle(btnMonday, days[i])
                    }

                    1 -> {
                        switchButtonStyle(btnTuesday, days[i])
                    }

                    2 -> {
                        switchButtonStyle(btnWenesday, days[i])
                    }

                    3 -> {
                        switchButtonStyle(btnThursday, days[i])
                    }

                    4 -> {
                        switchButtonStyle(btnFriday, days[i])
                    }

                    5 -> {
                        switchButtonStyle(btnSaturday, days[i])
                    }

                    6 -> {
                        switchButtonStyle(btnSunday, days[i])
                    }
                }
            }
        }
    }

    private fun initListeners() {
        btnMonday.setOnClickListener {
            scheduleScreenViewModel.switchDayToSchedule(0)
        }

        btnTuesday.setOnClickListener {
            scheduleScreenViewModel.switchDayToSchedule(1)
        }

        btnWenesday.setOnClickListener {
            scheduleScreenViewModel.switchDayToSchedule(2)
        }

        btnThursday.setOnClickListener {
            scheduleScreenViewModel.switchDayToSchedule(3)
        }

        btnFriday.setOnClickListener {
            scheduleScreenViewModel.switchDayToSchedule(4)
        }

        btnSaturday.setOnClickListener {
            scheduleScreenViewModel.switchDayToSchedule(5)
        }

        btnSunday.setOnClickListener {
            scheduleScreenViewModel.switchDayToSchedule(6)
        }
    }

    private fun switchButtonStyle(button: Button, selected: Boolean) {
        if (selected) {
            button.setTextColor(ContextCompat.getColor(context, R.color.mainGreen))
            button.setBackgroundResource(R.drawable.circle_border_background)
        } else {
            button.setTextColor(ContextCompat.getColor(context, R.color.black_33))
            button.setBackgroundResource(R.color.transparent)
        }
    }
}