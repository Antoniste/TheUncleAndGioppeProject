package com.example.theuncleandgioppeproject.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_porn")
class UserPorn (
    @ColumnInfo(name = "email")
    var email: String? =null,
    @ColumnInfo(name = "password")
    var password:String? =null,
    var log:Boolean? = false
){
    @PrimaryKey(autoGenerate = true)
    var idUser: Int =0
}