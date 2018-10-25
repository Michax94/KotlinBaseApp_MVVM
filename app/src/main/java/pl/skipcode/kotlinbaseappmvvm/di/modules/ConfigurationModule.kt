package pl.skipcode.kotlinbaseappmvvm.di.modules

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.ConfigurationImpl
import javax.inject.Singleton

@Module
class ConfigurationModule {

    @Singleton
    @Provides
    fun configuration(): IConfiguration =
            ConfigurationImpl()

}