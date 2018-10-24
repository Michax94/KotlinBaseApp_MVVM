package pl.skipcode.kotlinbaseappmvvm.feature.splash.module

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract
import pl.skipcode.kotlinbaseappmvvm.feature.splash.gear.SplashGear
import pl.skipcode.kotlinbaseappmvvm.feature.splash.navigation.SplashRouter
import pl.skipcode.kotlinbaseappmvvm.feature.splash.ui.SplashActivity

@Module
class SplashModule {

    @Provides
    fun provideGear(
            router: SplashContract.Router
    ): SplashContract.Gear =
            SplashGear(
                    router
            )

    @Provides
    fun provideRouter(
            activity: SplashActivity
    ): SplashContract.Router =
            SplashRouter(
                    activity
            )
}