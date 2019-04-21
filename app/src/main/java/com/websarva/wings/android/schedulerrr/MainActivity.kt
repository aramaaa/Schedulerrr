package com.websarva.wings.android.schedulerrr

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout
import io.realm.Realm
import io.realm.kotlin.where

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        realm = Realm.getDefaultInstance()
        val schedules = realm.where<Schedule>().findAll()

        recyclerView.layoutManager=LinearLayout(this)
        recyclerView.adapter = ScheduleAdapter(this, schedules)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

}
