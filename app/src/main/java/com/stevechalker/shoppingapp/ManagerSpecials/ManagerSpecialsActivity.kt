package com.stevechalker.shoppingapp.ManagerSpecials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.stevechalker.shoppingapp.ManagerSpecialsApplication
import com.stevechalker.shoppingapp.R
import javax.inject.Inject

class ManagerSpecialsActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: ManagerSpecialsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ManagerSpecialsApplication).appComponenent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.observeManagerSpecials().observe(this, Observer { managerSpecials ->
            managerSpecials.map { Log.d("STEVE", it.display_name) }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchManagerSpecials()
    }
}