package pl.skipcode.kotlinbaseappmvvm.feature.main.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.about.module.AboutModule
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.about.ui.AboutFragment
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.module.DashboardModule
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.ui.DashboardFragment

@Module
abstract class MainFragmentsBinderModule {

    @ContributesAndroidInjector(modules = [DashboardModule::class])
    abstract fun bindsDashboardFragment(): DashboardFragment

    @ContributesAndroidInjector(modules = [AboutModule::class])
    abstract fun bindsAboutFragment(): AboutFragment

}