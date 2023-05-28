package com.example.customviewaplication.data.details

import com.example.customviewaplication.data.CondoUnit
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnitDetailsMainService {
    @GET("unities")
    //query param da chamada
    //mock api retorna uma lista do unit
    suspend fun getUnit(@Query("id") id: String): Response<List<CondoUnit>>

}