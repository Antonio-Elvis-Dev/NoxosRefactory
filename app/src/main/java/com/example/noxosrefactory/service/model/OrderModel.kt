package com.example.noxosrefactory.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.sql.Date
import java.time.format.DateTimeFormatter

@Entity("order")
class OrderModel {

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @SerializedName("table")
    @ColumnInfo(name = "table")
    var table: Int = 0

    @SerializedName("status")
    @ColumnInfo(name = "status")
    var status: Boolean = false

    @SerializedName("draft")
    @ColumnInfo(name = "draft")
    var draft: Boolean = true

    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String = ""

    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    lateinit var create_at: String

    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    lateinit var updated_at: String
}


