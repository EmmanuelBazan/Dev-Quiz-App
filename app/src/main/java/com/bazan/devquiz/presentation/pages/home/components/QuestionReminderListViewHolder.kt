package com.bazan.devquiz.presentation.pages.home.components

import com.bazan.devquiz.data.database.relations.ReminderFull
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.R
import com.bazan.devquiz.presentation.utils.IconMapper

class QuestionReminderListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val technology = view.findViewById<TextView>(R.id.titleTopic)
    private val reminderTitle = view.findViewById<TextView>(R.id.titleReminder)
    private val schedule = view.findViewById<TextView>(R.id.txtScheduleItemReminder)
    private val difficulty = view.findViewById<TextView>(R.id.txtDifficultyItemReminder)
    private val icon = view.findViewById<ImageView>(R.id.imgIconItemReminder)
    fun render(reminder: ReminderFull, onClick: (idTechnology: Int, idDifficulty: Int) -> Unit) {
        technology.text = reminder.technology.name
        reminderTitle.text = reminder.reminder.name
        schedule.text = reminder.reminder.schedule
        difficulty.text = reminder.difficulty.name
        icon.setImageResource(IconMapper.getIconResource(reminder.technology.icon))

        view.setOnClickListener{
            onClick(reminder.technology.id,reminder.difficulty.id)
        }
    }
}