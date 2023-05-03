package com.example.theuncleandgioppeproject.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.theuncleandgioppeproject.R

class PreferencesManager(context: Context) {
    private val sharedPreferencesKey = context.getString(
        R.string.sp_key
    )


    private val prefs: SharedPreferences =
        context.getSharedPreferences(sharedPreferencesKey, MODE_PRIVATE)

    private val spLoginKey = context.getString(
        R.string.sp_login_key
    )

    var isUserLogged: Boolean = false
        get() = prefs.getBoolean(spLoginKey, false)
        set(value) {
            prefs.edit {
                putBoolean(spLoginKey, value)
            }
            field = value
        }
}