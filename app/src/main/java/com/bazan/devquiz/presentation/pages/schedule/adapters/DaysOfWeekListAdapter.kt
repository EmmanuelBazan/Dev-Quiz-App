package com.bazan.devquiz.presentation.pages.schedule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.R
import com.bazan.devquiz.presentation.pages.home.components.QuestionReminderListViewHolder
import com.bazan.devquiz.presentation.pages.schedule.components.DayOfWeekListViewHolder

class DaysOfWeekListAdapter (
    private val fileList: List<String>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return DayOfWeekListViewHolder(
            layoutInflater.inflate(
                R.layout.item_day_week,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = fileList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            when (holder) {
                is QuestionReminderListViewHolder -> {
                    val item = fileList[position]
                    holder.render()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}