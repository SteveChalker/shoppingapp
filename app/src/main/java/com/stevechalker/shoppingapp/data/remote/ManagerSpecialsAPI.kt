package com.stevechalker.shoppingapp.data.remote

import com.stevechalker.shoppingapp.data.model.ManagersSpecialResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ManagerSpecialsAPI {
    @GET("code-exercise-android/master/backup")
    fun getManagerSpecials(): Single<ManagersSpecialResponse>
}