package com.example.poemapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [poem::class], version = 2)
abstract class Poemdb : RoomDatabase(){
    abstract fun getPoemDao():PoemDao

    companion object{
        @Volatile
        private var INSTANCE: Poemdb? = null

        fun getDatabase(context: Context): Poemdb{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Poemdb::class.java,"poem_table"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}