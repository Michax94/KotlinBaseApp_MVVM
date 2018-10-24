package pl.skipcode.kotlinbaseappmvvm.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.BaseApplication
import pl.skipcode.kotlinbaseappmvvm.di.modules.ConfigurationModule
import pl.skipcode.kotlinbaseappmvvm.di.modules.NetworkModule
import pl.skipcode.kotlinbaseappmvvm.di.modules.RepositoryModule
import pl.skipcode.kotlinbaseappmvvm.di.modules.ServiceModule
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(app: Application): Context =
            app

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable =
            CompositeDisposable()
}

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ServiceModule::class,
    RepositoryModule::class,
    ConfigurationModule::class,
    ActivityBinderModule::class,
    ViewModelBinderModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}