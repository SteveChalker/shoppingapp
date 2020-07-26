package com.stevechalker.shoppingapp.manager_specials

import android.app.Activity
import android.util.DisplayMetrics
import com.stevechalker.shoppingapp.data.model.ManagerSpecial
import javax.inject.Inject

class ManagerSpecialsViewCalculator @Inject constructor() {

    fun calculateManagerSpecialViewSize(
        activity: Activity,
        canvasUnit: Int,
        managerSpecial: ManagerSpecial
    ): ManagerSpecial {
        val unitsInPixels = getScreenWidth(activity) / canvasUnit
        return managerSpecial.copy(
            width = unitsInPixels * managerSpecial.width,
            height = unitsInPixels * managerSpecial.height
        )
    }


    private fun getScreenWidth(activity: Activity): Int {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.widthPixels
    }
}