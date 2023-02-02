package com.example.roomdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable" )
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo
    val name: String?,
    @ColumnInfo
    val age: String?,
    @ColumnInfo
    val gender: String?,
    @ColumnInfo
    val email: String?,
        )
