package com.example.customviewaplication.data.details

class UnitDetailsMainRepository(private val unitDetailsRemoteDataSource: UnitDetailsRemoteDataSource) {

    suspend fun getUnit(id: String) = unitDetailsRemoteDataSource.getUnit(id)
}