package com.example.theuncleandgioppeproject.di.module


import android.content.Context
import androidx.room.Room
import com.example.theuncleandgioppeproject.db.DaoPorn
import com.example.theuncleandgioppeproject.db.PornDatabase
import com.example.theuncleandgioppeproject.repository.PornRepository
import com.example.theuncleandgioppeproject.db.UserPorn
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LoginModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(
        context,PornDatabase::class.java,"user_porn")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides @Singleton
    fun provideDao(db :PornDatabase)= db.daoPorn()

    @Provides
    fun provideEntity()=UserPorn()

    @Provides
    @Singleton
    fun provideUserRepository(dao:DaoPorn): PornRepository {
        return PornRepository(dao)
    }
}

