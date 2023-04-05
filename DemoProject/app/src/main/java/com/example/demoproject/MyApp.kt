package com.example.demoproject

import android.app.Application

class MyApp : Application() {
    var account: Account?=null

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}