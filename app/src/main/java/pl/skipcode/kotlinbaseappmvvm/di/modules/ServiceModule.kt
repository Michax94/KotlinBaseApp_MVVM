package pl.skipcode.kotlinbaseappmvvm.di.modules

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.utils.network.services.AuthService
import retrofit2.Retrofit

@Module
class ServiceModule{

    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService =
            retrofit.create(AuthService::class.java)

}