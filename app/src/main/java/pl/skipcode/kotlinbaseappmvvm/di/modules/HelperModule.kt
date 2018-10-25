package pl.skipcode.kotlinbaseappmvvm.di.modules

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.utils.network.errors.ApiErrorMapper

@Module
class HelperModule{

    @Provides
    fun provideApiErrorMapper(): ApiErrorMapper =
            ApiErrorMapper()

}