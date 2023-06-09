package com.example.theuncleandgioppeproject.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_porn")
class UserPorn (
    @ColumnInfo(name = "name")
    var name: String? =null,
    @ColumnInfo(name = "email")
    var email: String? =null,
    @ColumnInfo(name = "password")
    var password:String? =null,
){
    @PrimaryKey(autoGenerate = true)
    var idUser: Int =0
}