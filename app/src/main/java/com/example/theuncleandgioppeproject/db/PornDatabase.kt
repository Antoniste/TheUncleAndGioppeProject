package com.example.theuncleandgioppeproject.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserPorn::class], version = 3)
abstract class PornDatabase : RoomDatabase() {
    abstract fun daoPorn() : DaoPorn
}