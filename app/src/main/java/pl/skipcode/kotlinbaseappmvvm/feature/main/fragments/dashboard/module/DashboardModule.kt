package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.module

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.gear.DashboardGear
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.navigation.DashboardRouter
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.ui.DashboardFragment
import pl.skipcode.kotlinbaseappmvvm.feature.main.ui.MainActivity
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration

@Module
class DashboardModule {

    @Provides
    fun provideGear(
            fragment: DashboardFragment,
            configuration: IConfiguration,
            router: DashboardContract.Router,
            routerMain: MainContract.Router
    ): DashboardContract.Gear =
            DashboardGear(
                    fragment,
                    configuration,
                    router,
                    routerMain
            )

    @Provides
    fun provideRouter(
            activity: MainActivity
    ): DashboardContract.Router =
            DashboardRouter(
                    activity
            )

}