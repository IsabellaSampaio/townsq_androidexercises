package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    private var text: TextView? = null
    private var textEdit: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById(R.id.buttonView)
        text = findViewById(R.id.textView)
        textEdit = findViewById(R.id.editTextView)

        button?.setOnClickListener {
            val input = textEdit?.text.toString()
            text?.text = input
        }


    }
}