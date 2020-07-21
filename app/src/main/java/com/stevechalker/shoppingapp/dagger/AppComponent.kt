package com.stevechalker.shoppingapp.dagger

import com.stevechalker.shoppingapp.ManagerSpecials.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}