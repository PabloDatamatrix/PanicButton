package com.globalseguridad.panicbutton.di

import android.content.Context
import com.globalseguridad.panicbutton.data.DeviceRepository
import com.globalseguridad.panicbutton.data.MTCentralManagerDataSource
import com.globalseguridad.panicbutton.domain.DeviceUseCases
import com.globalseguridad.panicbutton.presentation.DeviceViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { (context: Context) -> MTCentralManagerDataSource(context) }
    single { DeviceRepository(get()) }
    single { DeviceUseCases(get()) }
    viewModel { DeviceViewModel(get()) }
}
