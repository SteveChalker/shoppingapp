package com.stevechalker.shoppingapp.manager_specials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexboxLayoutManager
import com.stevechalker.shoppingapp.ManagerSpecialsApplication
import com.stevechalker.shoppingapp.R
import javax.inject.Inject

class ManagerSpecialsActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: ManagerSpecialsViewModel

    val viewCalculator = ManagerSpecialsViewCalculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ManagerSpecialsApplication).appComponenent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_specials)

        val managerSpecialsRecyclerView =
            findViewById<RecyclerView>(R.id.manager_Specials_recyclerView)
        managerSpecialsRecyclerView.layoutManager = FlexboxLayoutManager(this)

        viewModel.observeManagerSpecials().observe(this, Observer { managerSpecialResponse ->
            val managerSpecialsList = managerSpecialResponse.managerSpecials.map {
                viewCalculator.calculateManagerSpecialViewSize(
                    this,
                    managerSpecialResponse.canvasUnit,
                    it
                )
            }

            managerSpecialsRecyclerView.adapter = ManagerSpecialsAdapter(managerSpecialsList)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchManagerSpecials()
    }
}