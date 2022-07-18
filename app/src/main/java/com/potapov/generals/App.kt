package com.potapov.generals

import android.app.Application
import com.potapov.generals.di.AppComponent
import com.potapov.generals.di.DaggerAppComponent
import com.potapov.generals.di.module.PresentationModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .presentationModule(PresentationModule(this))
                .build()
    }
}
