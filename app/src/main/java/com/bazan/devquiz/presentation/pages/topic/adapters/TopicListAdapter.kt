package com.bazan.devquiz.presentation.pages.topic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bazan.devquiz.R

const val FOOTER_VIEW = 1
const val HEADER_VIEW = 2

class TopicListAdapter(private val context: Context, private val topics: List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return topics.size + 2
    }

    override fun getItem(position: Int): Any {
        return topics[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_topic_list, parent, false)
        } else {
            view = convertView
        }

        return view
    }
}