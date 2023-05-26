package com.example.customviewaplication.data.main

import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.ui.retrofit.RetroFit
import java.io.IOException

class MainRemoteDataSource {

    private val service: MainService = getServiceInstance()

    private fun getServiceInstance() : MainService{
        return RetroFit.getInstance().create(MainService::class.java)
    }

    suspend fun getUnities(): Result<List<CondoUnit>> {
        val response = service.getUnities()
        return if(response.isSuccessful){
            Result.success(response.body().orEmpty())
        }else{
            Result.failure(IOException("An error occurred while it was fetching the data requested"))
        }
    }

}