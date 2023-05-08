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
    private  val spUserHome = context.getString(
        R.string.sp_user_name_home
    )
    private  val spCredentialLogin = context.getString(
        R.string.sp_credential_login
    )
    private  val spUserEmail = context.getString(
        R.string.sp_user_email_home
    )
    private  val spUserPassword = context.getString(
        R.string.sp_user_password_home
    )



    var isUserLogged: Boolean = false
        get() = prefs.getBoolean(spLoginKey, false)
        set(value) {
            prefs.edit {
                putBoolean(spLoginKey, value)
            }
            field = value
        }
    var credentialUser: Boolean = false
        get() = prefs.getBoolean(spCredentialLogin, false)
        set(value) {
            prefs.edit {
                putBoolean(spCredentialLogin, value)
            }
            field = value
        }
    var userName: String? = null
        get() = prefs.getString(spUserHome,"")
        set(value){
            prefs.edit{
                putString(spUserHome,value)
            }
            field =value
        }
    var userEmail: String? = null
        get() = prefs.getString(spUserEmail,"")
        set(value){
            prefs.edit{
                putString(spUserEmail,value)
            }
            field =value
        }
    var userPassword: String? = null
        get() = prefs.getString(spUserPassword,"")
        set(value){
            prefs.edit{
                putString(spUserPassword,value)
            }
            field =value
        }
}