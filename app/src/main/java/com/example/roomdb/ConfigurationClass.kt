package com.example.roomdb

import androidx.room.Room
import com.example.roomdb.repository.UserRepository
import com.example.roomdb.viewmodel.UserViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ConfigurationClass {
    fun modules() = commonModule + repositoryModule + viewModelModule
}

val repositoryModule = module {
    single { UserRepository(get()) }
}

val viewModelModule = module {
    viewModel { UserViewModel(get()) }
}

val commonModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            UserDatabase::class.java,
            "userDatabase"
        ).fallbackToDestructiveMigration().build()
    }
    single { get<UserDatabase>().userData() }
}
