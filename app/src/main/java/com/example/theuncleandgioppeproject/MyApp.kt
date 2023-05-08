package com.example.theuncleandgioppeproject

import android.app.Application
import com.example.theuncleandgioppeproject.utils.PreferencesManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
    val preferencesManager by lazy {
        PreferencesManager(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: MyApp
    }
}