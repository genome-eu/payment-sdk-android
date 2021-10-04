package eu.genome.sdk.payment.di

import android.app.Application
import android.content.SharedPreferences
import eu.genome.sdk.payment.SdkHelper
import eu.genome.sdk.payment.datamodule.api.Api
import eu.genome.sdk.payment.datamodule.repository.PayRepositoryImpl
import eu.genome.sdk.payment.datamodule.repository.PayRepository
import eu.genome.sdk.payment.model.PayTheme
import eu.genome.sdk.payment.ui.MainViewModel
import eu.genome.sdk.payment.utils.*
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { MainViewModel(androidApplication()) }
}

val facadeModule = module {
    single { SdkHelper() }
}

val dataModule = module {
    single { Api(getPrefs(androidApplication()), null) }
    single <PayRepository> { PayRepositoryImpl(get()) }
}

val utils = module {
    factory<DateInterface> {
        return@factory DateFormat()
    }
    single<IpHelper> { IpHelperImpl() }
    single<CountryISOHelper> { CountryISOHelperImpl() }
    single { CustomTabsHelper() }
    single { ExpiryParser() }
    factory { (theme: PayTheme?) -> EditTextValidator(theme) }
    factory { (theme: PayTheme?) -> UIComponentThemeEditor(theme) }

}
fun getPrefs(app: Application): SharedPreferences =
    app.getSharedPreferences("default", android.content.Context.MODE_PRIVATE)

