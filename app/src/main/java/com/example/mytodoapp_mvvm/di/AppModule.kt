package com.example.mytodoapp_mvvm.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mytodoapp_mvvm.data.TodoDAO
import com.example.mytodoapp_mvvm.data.TodoDatabase
import com.example.mytodoapp_mvvm.data.TodoRepoImpl
import com.example.mytodoapp_mvvm.data.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule  {
    @Provides
    @Singleton
    fun provideTodoDataBase(app: Application): TodoDatabase{
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db:TodoDatabase): TodoRepository {
        return TodoRepoImpl(db.dao)
    }
}