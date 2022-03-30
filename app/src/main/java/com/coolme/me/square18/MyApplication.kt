package com.coolme.me.square18

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application()//, Configuration.Provider
{
    override fun onCreate() {
        super.onCreate()
        //Realm.init(this)
    }

//    @Inject
//    lateinit var workerFactory: HiltWorkerFactory
//
//    override fun getWorkManagerConfiguration(): Configuration
//    {
//        return Configuration.Builder()
//                .setWorkerFactory(workerFactory)
//                .build()
//    }
}
