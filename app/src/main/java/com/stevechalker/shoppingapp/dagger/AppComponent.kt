package com.stevechalker.shoppingapp.dagger

import com.stevechalker.shoppingapp.manager_specials.ManagerSpecialsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(managerSpecialsActivity: ManagerSpecialsActivity)
}