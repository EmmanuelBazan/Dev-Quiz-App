package com.bazan.devquiz.presentation.pages.schedule.components

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import com.bazan.devquiz.R
import com.bazan.devquiz.presentation.pages.schedule.viewModel.ScheduleScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

class WeekDaysSelector(
    private val context: Context,
    private val activity: FragmentActivity,
    private val root: View,
    private val switchDayToSchedule: (index:Int) -> Unit,
    private val daysToSchedule: MutableLiveData<List<Boolean>>,
) {
    private lateinit var btnMonday: Button
    private lateinit var btnTuesday: Button
    private lateinit var btnWenesday: Button
    private lateinit var btnThursday: Button
    private lateinit var btnFriday: Button
    private lateinit var btnSaturday: Button
    private lateinit var btnSunday: Button

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
        daysToSchedule.observe(activity) { days ->
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
            switchDayToSchedule(0)
        }

        btnTuesday.setOnClickListener {
            switchDayToSchedule(1)
        }

        btnWenesday.setOnClickListener {
            switchDayToSchedule(2)
        }

        btnThursday.setOnClickListener {
            switchDayToSchedule(3)
        }

        btnFriday.setOnClickListener {
            switchDayToSchedule(4)
        }

        btnSaturday.setOnClickListener {
            switchDayToSchedule(5)
        }

        btnSunday.setOnClickListener {
            switchDayToSchedule(6)
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