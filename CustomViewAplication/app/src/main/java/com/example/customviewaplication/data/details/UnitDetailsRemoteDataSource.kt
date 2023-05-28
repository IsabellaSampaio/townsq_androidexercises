package com.example.customviewaplication.data.details

import com.example.customviewaplication.data.CondoUnit
import com.example.customviewaplication.data.retrofit.RetroFit
import java.io.IOException

class UnitDetailsRemoteDataSource {
    private val service: UnitDetailsMainService = getServiceInstance()

    private fun getServiceInstance(): UnitDetailsMainService {
        return RetroFit.getInstance().create(UnitDetailsMainService::class.java)
    }

    suspend fun getUnit(id: String): Result<CondoUnit?> {
        val response = service.getUnit(id)
        return if (response.isSuccessful) {
            Result.success(response.body()?.firstOrNull())
        } else {
            Result.failure(IOException("An error occurred while it was fetching the data requested"))
        }

    }

}