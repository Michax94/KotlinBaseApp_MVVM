package pl.skipcode.kotlinbaseappmvvm.feature.main.module

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.navigation.MainRouter
import pl.skipcode.kotlinbaseappmvvm.feature.main.ui.MainActivity

@Module
class MainModule {

    @Provides
    fun provideRouter(
            activity: MainActivity
    ): MainContract.Router =
            MainRouter(
                    activity
            )

}