package pl.skipcode.kotlinbaseappmvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.skipcode.kotlinbaseappmvvm.feature.auth.viewModel.AuthViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.viewModel.DashboardViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.main.viewModel.MainViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.splash.viewModel.SplashViewModel

@Module
abstract class ViewModelBinderModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    /**
     * Activities
     */

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel

    /**
     * Fragments
     */

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel

}