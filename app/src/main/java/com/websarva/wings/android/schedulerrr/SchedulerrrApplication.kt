package com.websarva.wings.android.schedulerrr

import android.app.Application
import io.realm.Realm

class SchedulerrrApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}