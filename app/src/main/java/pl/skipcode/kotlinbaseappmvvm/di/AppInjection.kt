package pl.skipcode.kotlinbaseappmvvm.di

import android.app.Application
import android.content.Context
import pl.skipcode.kotlinbaseappmvvm.BaseApplication

//@Module
//class AppModule {
//
//    @Provides
//    fun provideContext(app: Application): Context =
//            app
//
//    @Provides
//    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
//}
//
//@Singleton
//@Component(modules = [
//    AndroidInjectionModule::class,
//    AppModule::class,
//    NetworkModule::class,
//    ConfigurationModule::class,
//    ActivityBinderModule::class
//])
//interface AppComponent {
//
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun bindApplication(app: Application): Builder
//
//        fun build(): AppComponent
//    }
//
//    fun inject(app: BaseApplication)
//}