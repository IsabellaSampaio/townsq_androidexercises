package com.example.fragmentactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentactivities.beta.BetaActivities

class MainActivity : AppCompatActivity() {
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.mainButton)
        button?.setOnClickListener {
            onNavButtonClicked()
        }
    }

    private fun onNavButtonClicked() {
        val getHome = Intent(this, BetaActivities::class.java)
        startActivity(getHome)
    }
}