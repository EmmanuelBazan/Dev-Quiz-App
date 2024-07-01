package com.bazan.devquiz.presentation.pages.topic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.bazan.devquiz.R
import com.bazan.devquiz.data.database.entities.TechnologyEntity

class TopicListAdapter(
    private val context: Context,
    private val topics: List<TechnologyEntity>,
    private val onClick: (idTech:Int) -> Unit
) :
    BaseAdapter() {

    override fun getCount(): Int {
        return topics.size
    }

    override fun getItem(position: Int): Any {
        return topics[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val title: TextView
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_topic_list, parent, false)
            title = view.findViewById(R.id.technologyTitle)
            title.text = topics[position].name
        } else {
            view = convertView
        }



        view.setOnClickListener{
            onClick(topics[position].id)
        }

        return view
    }
}