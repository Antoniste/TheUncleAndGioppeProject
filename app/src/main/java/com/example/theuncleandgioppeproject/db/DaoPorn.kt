package com.example.theuncleandgioppeproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.google.android.material.tabs.TabLayout.Tab
@Dao
interface DaoPorn {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(porn: UserPorn)
    @Query("SELECT * FROM user_porn WHERE email=:email AND password= :password")
    suspend fun select(email:String,password:String): UserPorn
}