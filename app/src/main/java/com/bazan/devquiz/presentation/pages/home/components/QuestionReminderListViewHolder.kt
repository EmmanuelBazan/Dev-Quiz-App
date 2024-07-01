package com.bazan.devquiz.presentation.pages.home.components

import com.bazan.devquiz.data.database.relations.ReminderFull
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.R

class QuestionReminderListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val technology = view.findViewById<TextView>(R.id.titleTopic)
    private val reminderTitle = view.findViewById<TextView>(R.id.titleReminder)
    private val schedule = view.findViewById<TextView>(R.id.txtScheduleItemReminder)
    private val difficulty = view.findViewById<TextView>(R.id.txtDifficultyItemReminder)
    fun render(reminder: ReminderFull) {
        technology.text = reminder.technology.name
        reminderTitle.text = reminder.reminder.name
        schedule.text = reminder.reminder.schedule
        difficulty.text = reminder.difficulty.name
    }
}