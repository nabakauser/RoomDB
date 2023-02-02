package com.example.roomdb.application

import android.app.Application
import com.example.roomdb.ConfigurationClass
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RoomDbApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RoomDbApplication)
            modules(ConfigurationClass.modules())
        }
    }
}