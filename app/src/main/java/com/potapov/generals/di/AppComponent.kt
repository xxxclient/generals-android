package com.potapov.generals.di

import com.potapov.generals.di.module.DataModule
import com.potapov.generals.di.module.DomainModule
import com.potapov.generals.di.module.PresentationModule
import com.potapov.generals.presentation.MainActivity
import dagger.Component

@Component(modules = [PresentationModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}