package com.bazan.devquiz.presentation.pages.schedule.components

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.bazan.devquiz.R

class WeekDaysSelector(
    private val context: Context,
    private val root: View
) {
    private lateinit var btnMonday: Button
    private lateinit var btnTuesday: Button
    private lateinit var btnWenesday: Button
    private lateinit var btnThursday: Button
    private lateinit var btnFriday: Button
    private lateinit var btnSaturday: Button
    private lateinit var btnSunday: Button

    private var isMonday = true
    private var isTuesday = true
    private var isWenesday = true
    private var isThursday = true
    private var isFriday = true
    private var isSaturday = true
    private var isSunday = true
    init {
        initComponents()
        initListeners()
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

    private fun initListeners() {
        btnMonday.setOnClickListener {
            isMonday = !isMonday
            if (isMonday) {
                btnMonday.setTextColor(ContextCompat.getColor(context, R.color.mainGreen))
                btnMonday.setBackgroundResource(R.drawable.circle_border_background)
            } else {
                btnMonday.setTextColor(ContextCompat.getColor(context,R.color.black_33))
                btnMonday.setBackgroundResource(R.color.transparent)
            }
        }

        btnTuesday.setOnClickListener {
            isTuesday = !isTuesday
            if (isTuesday) {
                btnTuesday.setTextColor(ContextCompat.getColor(context, R.color.mainGreen))
                btnTuesday.setBackgroundResource(R.drawable.circle_border_background)
            } else {
                btnTuesday.setTextColor(ContextCompat.getColor(context,R.color.black_33))
                btnTuesday.setBackgroundResource(R.color.transparent)
            }
        }

        btnWenesday.setOnClickListener {
            isWenesday = !isWenesday
            if (isWenesday) {
                btnWenesday.setTextColor(ContextCompat.getColor(context, R.color.mainGreen))
                btnWenesday.setBackgroundResource(R.drawable.circle_border_background)
            } else {
                btnWenesday.setTextColor(ContextCompat.getColor(context,R.color.black_33))
                btnWenesday.setBackgroundResource(R.color.transparent)
            }
        }

        btnThursday.setOnClickListener {
            isThursday = !isThursday
            if (isThursday) {
                btnThursday.setTextColor(ContextCompat.getColor(context, R.color.mainGreen))
                btnThursday.setBackgroundResource(R.drawable.circle_border_background)
            } else {
                btnThursday.setTextColor(ContextCompat.getColor(context,R.color.black_33))
                btnThursday.setBackgroundResource(R.color.transparent)
            }
        }

        btnFriday.setOnClickListener {
            isFriday = !isFriday
            if (isFriday) {
                btnFriday.setTextColor(ContextCompat.getColor(context, R.color.mainGreen))
                btnFriday.setBackgroundResource(R.drawable.circle_border_background)
            } else {
                btnFriday.setTextColor(ContextCompat.getColor(context,R.color.black_33))
                btnFriday.setBackgroundResource(R.color.transparent)
            }
        }

        btnSaturday.setOnClickListener {
            isSaturday = !isSaturday
            if (isSaturday) {
                btnSaturday.setTextColor(ContextCompat.getColor(context, R.color.mainGreen))
                btnSaturday.setBackgroundResource(R.drawable.circle_border_background)
            } else {
                btnSaturday.setTextColor(ContextCompat.getColor(context,R.color.black_33))
                btnSaturday.setBackgroundResource(R.color.transparent)
            }
        }

        btnSunday.setOnClickListener {
            isSunday = !isSunday
            if (isSunday) {
                btnSunday.setTextColor(ContextCompat.getColor(context, R.color.mainGreen))
                btnSunday.setBackgroundResource(R.drawable.circle_border_background)
            } else {
                btnSunday.setTextColor(ContextCompat.getColor(context,R.color.black_33))
                btnSunday.setBackgroundResource(R.color.transparent)
            }
        }
    }
}