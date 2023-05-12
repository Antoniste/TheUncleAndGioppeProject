package com.example.theuncleandgioppeproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.google.android.material.tabs.TabLayout.Tab
@Dao
interface DaoPorn {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(porn: UserPorn)
    @Query("SELECT * FROM user_porn WHERE email=:email AND password= :password")
    suspend fun select(email:String,password:String): UserPorn

/*    @Query("UPDATE user_porn SET log=:log WHERE idUser=:id")
        suspend fun update(log:Boolean,id:Int)*/

    @Query("SELECT * FROM user_porn WHERE idUser=0")
    suspend fun selectFirst():UserPorn
}