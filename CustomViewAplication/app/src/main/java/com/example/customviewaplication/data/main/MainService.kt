package com.example.customviewaplication.data.main

import com.example.customviewaplication.data.CondoUnit
import retrofit2.Response
import retrofit2.http.GET

interface MainService {

    @GET("unities")
    suspend fun getUnities(): Response<List<CondoUnit>>
}