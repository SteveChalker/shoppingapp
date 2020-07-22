package com.stevechalker.shoppingapp.data.model

data class ManagersSpecialResponse(
    val canvasUnit: Int,
    val managerSpecials: List<ManagerSpecial>
)

data class ManagerSpecial(
    val imageUrl: String,
    val width: Int,
    val height: Int,
    val display_name: String,
    val original_price: String,
    val price: String
)