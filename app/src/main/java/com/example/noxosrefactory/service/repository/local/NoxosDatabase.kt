package com.example.noxosrefactory.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noxosrefactory.service.model.OrderDataModel
import com.example.noxosrefactory.service.model.OrderModel

@Database(entities = [OrderModel::class], version = 1)
abstract class NoxosDatabase : RoomDatabase() {

abstract  fun orderDAO():OrderDAO
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