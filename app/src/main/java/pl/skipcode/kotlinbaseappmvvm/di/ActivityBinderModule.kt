package pl.skipcode.kotlinbaseappmvvm.di

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.skipcode.kotlinbaseappmvvm.feature.auth.module.AuthModule
import pl.skipcode.kotlinbaseappmvvm.feature.auth.ui.AuthActivity
import pl.skipcode.kotlinbaseappmvvm.feature.main.module.MainFragmentsBinderModule
import pl.skipcode.kotlinbaseappmvvm.feature.main.module.MainModule
import pl.skipcode.kotlinbaseappmvvm.feature.main.ui.MainActivity
import pl.skipcode.kotlinbaseappmvvm.feature.splash.module.SplashModule
import pl.skipcode.kotlinbaseappmvvm.feature.splash.ui.SplashActivity

@Module
abstract class ActivityBinderModule {

    @Binds
    abstract fun activity(activity: AppCompatActivity): AppCompatActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindsSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [MainModule::class, MainFragmentsBinderModule::class])
    abstract fun bindsMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [AuthModule::class])
    abstract fun bindsAuthActivity(): AuthActivity
}