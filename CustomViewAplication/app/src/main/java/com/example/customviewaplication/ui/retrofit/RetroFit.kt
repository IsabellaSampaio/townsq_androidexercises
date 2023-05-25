package com.example.customviewaplication.ui.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFit {

    private const val url = "https://6450f83ea32219691156c64e.mockapi.io/api/v1/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}