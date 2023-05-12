package com.example.theuncleandgioppeproject.repository

import com.example.theuncleandgioppeproject.db.DaoPorn
import com.example.theuncleandgioppeproject.db.UserPorn
import javax.inject.Inject

class PornRepository @Inject constructor(private var dao: DaoPorn) {
    suspend fun select(email: String, password: String): UserPorn {
        return dao.select(email, password)
    }
    suspend fun insertUser(user: UserPorn) {
        dao.insert(user)
    }

    suspend fun selectFirst():UserPorn{
        return dao.selectFirst()
    }
   /* suspend fun update(log:Boolean,id:Int) {
        dao.update(log,id)
    }*/
}