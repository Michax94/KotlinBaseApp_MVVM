package pl.skipcode.kotlinbaseappmvvm.di.modules

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.utils.network.services.AuthService
import pl.skipcode.kotlinbaseappmvvm.utils.repository.auth.AuthRepository
import pl.skipcode.kotlinbaseappmvvm.utils.repository.auth.IAuthRepository

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(
            service: AuthService
    ): IAuthRepository =
            AuthRepository(
                    service
            )

}