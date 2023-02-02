package com.example.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb.model.User


@Database(entities = [User::class], version = 1, exportSchema = false )
abstract class UserDatabase: RoomDatabase() {

    abstract fun userData(): UserDao

}
// why synchronized?

// This is to control different threads accessing the database at once,
// to prevent multiple instances being created. If you didn't synchronise here,
// then two different threads could both create a new instance of the database,
// whereas the singleton pattern is supposed to facilitate a single shared
// instance across the lifecycle of your program.

//multiple instances of the room  database becomes very expensive for the performance