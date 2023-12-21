package com.example.noxosrefactory.service.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.noxosrefactory.service.model.OrderModel

@Dao
interface OrderDAO {
    @Insert
    fun save(list:List<OrderModel>)

    @Query("select * from `order`")
    fun list():List<OrderModel>
}