package com.example.fragmentactivities.beta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentactivities.R

class BetaActivities : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beta_activities)

        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigation_fragment) as NavHostFragment
        val navigationController = navigationHostFragment.navController

        navigationController.setGraph(R.navigation.navigation_nav)
    }


}