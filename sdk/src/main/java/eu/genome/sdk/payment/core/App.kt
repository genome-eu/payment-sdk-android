package eu.genome.sdk.payment.core

import android.app.Application
import eu.genome.sdk.payment.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)

            modules(
                listOf(
                    viewModelModule,
                    utils,
                    dataModule
                )
            )
        }
    }
}