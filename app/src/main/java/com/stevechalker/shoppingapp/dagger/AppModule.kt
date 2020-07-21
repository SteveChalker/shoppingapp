package com.stevechalker.shoppingapp.dagger

import com.stevechalker.shoppingapp.ManagerSpecialsApplication
import com.stevechalker.shoppingapp.data.dagger.DataModule
import dagger.Module
import dagger.Provides

@Module(includes = [DataModule::class])
class AppModule(
    private val application: ManagerSpecialsApplication
) {
    @Provides
    fun provideApplication() = application
}