package pl.skipcode.kotlinbaseappmvvm.feature.auth.module

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.feature.auth.AuthContract
import pl.skipcode.kotlinbaseappmvvm.feature.auth.gear.AuthGear
import pl.skipcode.kotlinbaseappmvvm.feature.auth.navigation.AuthRouter
import pl.skipcode.kotlinbaseappmvvm.feature.auth.ui.AuthActivity

@Module
class AuthModule {

    @Provides
    fun provideGear(
            activity: AuthActivity,
            router: AuthContract.Router
    ): AuthContract.Gear =
            AuthGear(
                    activity,
                    router
            )

    @Provides
    fun provideRouter(
            activity: AuthActivity
    ): AuthContract.Router =
            AuthRouter(
                    activity
            )
}