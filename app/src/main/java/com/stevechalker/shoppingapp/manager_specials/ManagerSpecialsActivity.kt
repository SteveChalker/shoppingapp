package com.stevechalker.shoppingapp.manager_specials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.airbnb.epoxy.EpoxyRecyclerView
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
            findViewById<EpoxyRecyclerView>(R.id.manager_Specials_recyclerView)

        viewModel.observeManagerSpecials().observe(this, Observer { managerSpecialResponse ->

            val managerSpecialsList = managerSpecialResponse.managerSpecials.map {
                viewCalculator.calculateManagerSpecialViewSize(
                    this,
                    managerSpecialResponse.canvasUnit,
                    it
                )
            }

            managerSpecialsRecyclerView.apply {
                withModels {
                    managerSpecialsList.map {
                        managerSpecials {
                            id(it.display_name)
                            managerSpecial(it)
                        }
                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchManagerSpecials()
    }
}