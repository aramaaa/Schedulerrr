package com.websarva.wings.android.schedulerrr

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.websarva.wings.android.schedulerrr.databinding.ViewCellBinding
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import org.jetbrains.anko.startActivity

class ScheduleAdapter(private val context: Context, private val collection: OrderedRealmCollection<Schedule>?,private val autoUpdate :Boolean, private val listener: ScheduleListener)
    : RealmRecyclerViewAdapter<Schedule,ScheduleAdapter.viewHolder>(collection,autoUpdate){

    override fun getItemCount(): Int {
        return collection?.size ?: 0    /* ?:はエルビス演算子 collectionがnullのとき0を返す */
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_cell,p0,false)
        return viewHolder(DataBindingUtil.bind(view)!!) /* !!はnullのときNPE、nullじゃないとその値を返す */
    }

    override fun onBindViewHolder(p0: viewHolder, p1: Int) {
        val schedule = collection?.get(p1)
        p0.binding.cellDate.text = android.text.format.DateFormat.format("yyyy/MM/dd HH:mm",schedule?.date)
        p0.binding.cellTitle.text = schedule?.title

        /* クリックイベント */
        p0.binding.cellDate.setOnClickListener {
            listener.onClickRecyclerViewButton(p0.binding.cellDate, schedule?.id)
        }
    }

    class viewHolder(val binding: ViewCellBinding):RecyclerView.ViewHolder(binding.root)
}
