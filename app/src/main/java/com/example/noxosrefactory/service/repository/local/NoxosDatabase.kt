package com.example.noxosrefactory.service.repository.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class NoxosDatabase : RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: NoxosDatabase

        fun getDatabase(context: Context): NoxosDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context, NoxosDatabase::class.java, "noxosdb")
                    .allowMainThreadQueries().build()

            }
            return INSTANCE
        }

    }
}