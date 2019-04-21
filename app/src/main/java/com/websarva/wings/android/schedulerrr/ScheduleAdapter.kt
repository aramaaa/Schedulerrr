package com.websarva.wings.android.schedulerrr

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.RealmBaseAdapter
import io.realm.RealmResults
import java.lang.reflect.Array.get

class ScheduleAdapter(context:Context,val schedules:RealmResults<Schedule>) : RealmBaseAdapter<Schedule>() {
    val inflater = LayoutInflater.from(context)

    override fun onCreatViewHolder(p0:ViewGroup,p1:Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout./*わからん*/, p0,false))
    }
    override fun getItemCount():Int {
        return schedules.size
    }
    override fun onBindViewHolder(p0:ViewHolder, p1: Int){
        p0.textView.text = //わからん
    }
}
//わからん
class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val date = itemView.findViewById<TextView>(android.R.id.text1)
    val textView:TextView = itemView.findViewById(R.id.textView)
}