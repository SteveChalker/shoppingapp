package com.stevechalker.shoppingapp.ManagerSpecials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.airbnb.epoxy.EpoxyRecyclerView
import com.stevechalker.shoppingapp.ManagerSpecialsApplication
import com.stevechalker.shoppingapp.R
import javax.inject.Inject

class ManagerSpecialsActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: ManagerSpecialsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ManagerSpecialsApplication).appComponenent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_specials)

        val managerSpecialsList =
            findViewById<EpoxyRecyclerView>(R.id.manager_Specials_recyclerView)

        viewModel.observeManagerSpecials().observe(this, Observer { managerSpecials ->

            managerSpecialsList.apply {
                withModels {
                    managerSpecials.map {
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