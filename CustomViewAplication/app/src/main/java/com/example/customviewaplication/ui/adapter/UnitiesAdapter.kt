package com.example.customviewaplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.customviewaplication.R
import com.example.customviewaplication.data.CondoUnit

class UnitiesAdapter : RecyclerView.Adapter<UnitiesAdapter.ViewHolder>() {

    private var unities: List<CondoUnit> = listOf()

    fun setUnities(unitiesList: List<CondoUnit>) {
        this.unities = unitiesList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.condo_unit_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = unities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = unities[position]
        holder.bind(item)

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var condoImageView: ImageView? = view.findViewById(R.id.condo_image_view)
        private var unityNameTextView: TextView? = view.findViewById(R.id.unity_name_text_view)
        private var unityDescriptionTextView: TextView? =
            view.findViewById(R.id.unity_description_text_view)

        fun bind(unit: CondoUnit) {
            unityNameTextView?.text = unit.unityName
            unityDescriptionTextView?.text = unit.unityDescription
            condoImageView?.load(unit.url)
        }
    }
}