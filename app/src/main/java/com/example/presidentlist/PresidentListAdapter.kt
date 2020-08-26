package com.example.presidentlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PresidentListAdapter(context: Context, private val presidents: MutableList<President>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return presidents.size
    }

    override fun getItem(p: Int): Any {
        return presidents[p]
    }

    override fun getItemId(p: Int): Long {
        return p.toLong()
    }

    override fun getView(p: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item, parent, false)

        val thisPresident = presidents[p]

        var tv = rowView.findViewById(R.id.tvName) as TextView
        tv.text = thisPresident.name

        tv = rowView.findViewById(R.id.tvStartDuty) as TextView
        tv.text = Integer.toString(thisPresident.startDuty)

        tv = rowView.findViewById(R.id.tvEndDuty) as TextView
        tv.text = Integer.toString(thisPresident.endDuty)

        return rowView
    }
}