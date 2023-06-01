package com.example.customviewaplication.ui.di

import com.example.customviewaplication.data.main.MainRemoteDataSource
import com.example.customviewaplication.data.main.MainRepository
import com.example.customviewaplication.data.main.MainService
import com.example.customviewaplication.ui.list.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

var unitiesModule = module {
    factory { get<Retrofit>().create(MainService::class.java) as MainService }
    factory { MainRemoteDataSource(get()) }
    factory { MainRepository(get()) }
    viewModel { MainViewModel(get()) }
}