package com.example.customviewaplication.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.customviewaplication.R
import com.example.customviewaplication.data.Residents


class ResidentsAdapter : RecyclerView.Adapter<ResidentsAdapter.ViewHolder>() {

    private var residents: List<Residents> = listOf()

    fun setResidents(residents: List<Residents>){
        this.residents = residents
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.residents_unit, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = residents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = residents[position]
        holder.bind(item)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private var residentImageView: ImageView? = view.findViewById(R.id.residentPicture)
        private var residentTextView: TextView? = view.findViewById(R.id.residentName)

        fun bind(resident: Residents){
            residentTextView?.text = resident.name
            residentImageView?.load(resident.profilePicture)
        }
    }



}