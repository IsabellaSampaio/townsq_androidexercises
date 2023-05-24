package com.example.customviewaplication.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import com.example.customviewaplication.R

class SearchBarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var searchEditText: EditText? = null
    private var searchIconButton: ImageButton? = null
    private var onQueryChanged: ((String) -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_search_bar, this, true)
        searchEditText = findViewById(R.id.searchEditText)
        searchIconButton = findViewById(R.id.searchIconButton)
    }

    fun newInstance(onQueryChanged: (String) -> Unit) {
        this.onQueryChanged = onQueryChanged
        setupViews()
    }

    private fun setupViews() {
        searchEditText?.addTextChangedListener { inputText ->
            onQueryChanged?.invoke(inputText.toString())
        }
    }
}