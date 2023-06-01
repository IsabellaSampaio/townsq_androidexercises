package com.example.customviewaplication.data.main

class MainRepository(private val mainDataSource: MainRemoteDataSource) {

    suspend fun getUnities() = mainDataSource.getUnities()

}