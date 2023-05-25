package com.example.customviewaplication.data.main

class MainRepository(private val mainDataSource: MainDataSource = MainDataSource()) {

    suspend fun getUnities() = mainDataSource.getUnities()

}