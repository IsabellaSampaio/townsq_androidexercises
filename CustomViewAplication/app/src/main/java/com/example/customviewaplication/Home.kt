package com.example.customviewaplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.customviewaplication.ui.list.MainActivity

class Home: AppCompatActivity() {

    private var homeButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_main)

        homeButton = findViewById(R.id.homeButton)
        homeButton?.setOnClickListener{
            onNavButtonClicked()
        }
    }

    private fun onNavButtonClicked(){
        val getHome = Intent(this, MainActivity::class.java)
        startActivity(getHome)
    }
}