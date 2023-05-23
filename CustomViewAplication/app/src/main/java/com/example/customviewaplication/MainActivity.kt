package com.example.customviewaplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var condoCardView: CustomViewCard? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        condoCardView = findViewById(R.id.condo_unit_card)
        setupViews()
    }

    private fun setupViews(){
        condoCardView?.newInstance(mockCondoUnitView())
    }

    private fun mockCondoUnitView(): CondoUnit{
        return CondoUnit(
            id = "1",
            unityName = "Mountain Ranch Luxury",
            unityDescription = "Aspen Grove Ranch is a truly elegant Colorado estate with out-of-this-world Rocky Mountain views.",
            url = "https://www.mountainliving.com/content/uploads/data-import/9882388e/ColoradoRanch0614Exterior0157-fdc41d50.jpg"
        )
    }
}