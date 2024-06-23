package com.bazan.devquiz.presentation.pages.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.R
import com.bazan.devquiz.presentation.components.FooterViewHolder
import com.bazan.devquiz.presentation.components.HeaderViewHolder
import com.bazan.devquiz.presentation.pages.home.components.QuestionReminderListViewHolder

const val FOOTER_VIEW = 1
const val HEADER_VIEW = 2

class QuestionReminderListAdapter(
    private val fileList: List<String>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        if (viewType == FOOTER_VIEW) {
            return FooterViewHolder(
                layoutInflater.inflate(
                    R.layout.footer_view_holder,
                    parent,
                    false
                )
            )
        } else if (viewType == HEADER_VIEW) {
            return HeaderViewHolder(
                layoutInflater.inflate(
                    R.layout.header_view_holder,
                    parent,
                    false
                )
            )
        } else {
            return QuestionReminderListViewHolder(
                layoutInflater.inflate(
                    R.layout.item_question_reminder,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = fileList.size + 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            when (holder) {
                is QuestionReminderListViewHolder -> {
                    val item = fileList[position - 1]
                    holder.render()
                }
                is HeaderViewHolder -> {
                    holder.ren()
                }
                is FooterViewHolder -> {
                    holder.ren()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return HEADER_VIEW
        } else if (position == fileList.size + 1) {
            return FOOTER_VIEW
        }
        return super.getItemViewType(position)
    }
}