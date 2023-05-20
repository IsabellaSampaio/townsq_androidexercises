package com.example.fragmentactivities.beta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragmentactivities.R

class B2Fragment : Fragment() {
    private val button: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b2, container, false)
        val button = view.findViewById<Button>(R.id.buttonB2)
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_betaTwoFragment_to_betaThreeFragment2)
        }
        return view
    }

}