package pl.skipcode.kotlinbaseappmvvm.feature.splash.module

import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract
import pl.skipcode.kotlinbaseappmvvm.feature.splash.navigation.SplashRouter
import pl.skipcode.kotlinbaseappmvvm.feature.splash.presentation.SplashPresenter
import pl.skipcode.kotlinbaseappmvvm.feature.splash.ui.SplashActivity
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.ConfigurationInterface

//@Module
//class SplashModule {
//
//    @Provides
//    fun provideRouter(
//            activity: SplashActivity
//    ): SplashContract.Router =
//            SplashRouter(
//                    activity
//            )
//
//    @Provides
//    fun providePresenter(
//            router: SplashContract.Router,
//            configurationInterface: ConfigurationInterface,
//            compositeDisposable: CompositeDisposable
//    ): SplashContract.Presenter =
//            SplashPresenter(
//                    router,
//                    configurationInterface,
//                    compositeDisposable
//            )
//}