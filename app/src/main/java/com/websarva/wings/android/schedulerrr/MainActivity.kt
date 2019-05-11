package com.websarva.wings.android.schedulerrr

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.TextView
import io.realm.Realm
import io.realm.kotlin.where

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.startActivity
import com.websarva.wings.android.schedulerrr.ScheduleEditActivity as ScheduleEditActivity

class MainActivity : AppCompatActivity(), ScheduleListener {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        realm = Realm.getDefaultInstance()
        val schedules = realm.where<Schedule>().findAll()   /* realmインスタンスからデータ取得して変数に格納 */
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ScheduleAdapter(applicationContext, schedules, false, this)

        fab.setOnClickListener {
            startActivity<ScheduleEditActivity>()
        }


    }

    override fun onClickRecyclerViewButton(text: TextView, id: Long?) {
        startActivity<ScheduleEditActivity>(
            "schedule_id" to id
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}

