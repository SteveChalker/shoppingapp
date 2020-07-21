package com.stevechalker.shoppingapp.data

import com.stevechalker.shoppingapp.data.remote.ManagerSpecialsAPI
import javax.inject.Inject

class ManagerSpecialsRepository @Inject constructor(
    private val managerSpecialsAPI: ManagerSpecialsAPI
){
    fun fetchManagerSpecials() = managerSpecialsAPI.getManagerSpecials()
}