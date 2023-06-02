package com.example.customviewaplication.ui.details.di

import UnitDetailsViewModelFactory
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.customviewaplication.data.details.UnitDetailsMainRepository
import com.example.customviewaplication.data.details.UnitDetailsMainService
import com.example.customviewaplication.data.details.UnitDetailsRemoteDataSource
import com.example.customviewaplication.ui.details.UnitDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.getScopeId
import org.koin.core.component.getScopeName
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module
import retrofit2.Retrofit

var unitDetailsModule = module {
    factory { get<Retrofit>().create(UnitDetailsMainService::class.java) as UnitDetailsMainService }
    factory { UnitDetailsRemoteDataSource(get()) }
    factory { UnitDetailsMainRepository(get()) }
    viewModel { UnitDetailsViewModel(get(), get()) }
}

