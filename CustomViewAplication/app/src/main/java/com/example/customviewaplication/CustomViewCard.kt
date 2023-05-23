package com.example.customviewaplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load

class CustomViewCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var condoImageView: ImageView? = null
    private var unityNameTextView: TextView? = null
    private var unityDescriptionTextView: TextView? = null
    private var condoUnit: CondoUnit? = null


    init {
        LayoutInflater.from(context).inflate(R.layout.condo_unit_card, this, true)
        condoImageView = findViewById(R.id.condo_image_view)
        unityNameTextView = findViewById(R.id.unity_name_text_view)
        unityDescriptionTextView = findViewById(R.id.unity_description_text_view)
    }

    fun newInstance(condoUnit: CondoUnit){
        this.condoUnit = condoUnit
        setupViews()
    }

    private fun setupViews() {
        unityNameTextView?.text = condoUnit?.unityName
        unityDescriptionTextView?.text = condoUnit?.unityDescription
        condoImageView?.load(condoUnit?.url)
    }


}
