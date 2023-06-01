package com.example.customviewaplication.ui.details

import android.app.Application
import com.example.customviewaplication.data.di.networkModule
import com.example.customviewaplication.ui.details.di.unitDetailsModule
import com.example.customviewaplication.ui.di.unitiesModule
import org.koin.core.context.startKoin

class UnitiesApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(
                networkModule,
                unitiesModule,
                unitDetailsModule
            )
        }
    }
}