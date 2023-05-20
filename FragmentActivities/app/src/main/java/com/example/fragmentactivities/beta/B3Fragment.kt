package com.example.fragmentactivities.beta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragmentactivities.R

class B3Fragment : Fragment() {
    private val button: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b3, container, false)
        val button = view.findViewById<Button>(R.id.buttonB3)
        button.setOnClickListener {
            activity?.finish()
        }
        return view
    }
}