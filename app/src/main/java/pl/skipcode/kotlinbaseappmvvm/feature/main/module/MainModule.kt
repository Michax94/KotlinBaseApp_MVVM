package pl.skipcode.kotlinbaseappmvvm.feature.main.module

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.gear.MainGear
import pl.skipcode.kotlinbaseappmvvm.feature.main.navigation.MainRouter
import pl.skipcode.kotlinbaseappmvvm.feature.main.ui.MainActivity
import pl.skipcode.kotlinbaseappmvvm.utils.tools.permissions.IPermissionsHelper
import pl.skipcode.kotlinbaseappmvvm.utils.tools.permissions.PermissionsHelper

@Module
class MainModule {

    @Provides
    fun provideGear(
            activity: MainActivity,
            router: MainContract.Router,
            permissionsHelper: IPermissionsHelper
    ): MainContract.Gear =
            MainGear(
                    activity,
                    router,
                    permissionsHelper
            )

    @Provides
    fun provideRouter(
            activity: MainActivity
    ): MainContract.Router =
            MainRouter(
                    activity
            )

    @Provides
    fun providePermissionsHelper(
            activity: MainActivity
    ): IPermissionsHelper =
            PermissionsHelper(activity)
}