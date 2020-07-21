package com.stevechalker.shoppingapp

import android.app.Application
import com.stevechalker.shoppingapp.dagger.AppComponent
import com.stevechalker.shoppingapp.dagger.AppModule
import com.stevechalker.shoppingapp.dagger.DaggerAppComponent
import com.stevechalker.shoppingapp.data.dagger.DataModule

class ManagerSpecialsApplication : Application() {
    val appComponenent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .dataModule(DataModule())
            .build()
    }
}