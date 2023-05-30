package com.example.customviewaplication.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.customviewaplication.R
import com.example.customviewaplication.data.CondoUnit

class UnitiesAdapter(private val onCardClicked: (String) -> Unit) : RecyclerView.Adapter<UnitiesAdapter.ViewHolder>() {

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
        private var viewRoot: CardView = view.findViewById(R.id.custom_card)
        private var condoImageView: ImageView? = view.findViewById(R.id.condo_image_view)
        private var unityNameTextView: TextView? = view.findViewById(R.id.unity_name_text_view)
        private var unityDescriptionTextView: TextView? = view.findViewById(R.id.unity_description_text_view)

        fun bind(unit: CondoUnit) {
            unityNameTextView?.text = unit.unitName
            unityDescriptionTextView?.text = unit.unitDescription
            condoImageView?.load(unit.unitPicture)
            viewRoot.setOnClickListener{
                onCardClicked(unit.id)
            }

        }
    }
}