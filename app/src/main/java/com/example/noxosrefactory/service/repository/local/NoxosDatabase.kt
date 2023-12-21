package com.example.noxosrefactory.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noxosrefactory.service.model.OrderDataModel
import com.example.noxosrefactory.service.model.OrderModel

abstract class NoxosDatabase : RoomDatabase() {

    @Database(entities = [OrderDataModel::class], version = 1)

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