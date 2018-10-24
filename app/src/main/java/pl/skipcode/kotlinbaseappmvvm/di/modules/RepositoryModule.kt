package pl.skipcode.kotlinbaseappmvvm.di.modules

import dagger.Module
import dagger.Provides
import pl.skipcode.kotlinbaseappmvvm.utils.network.services.AuthService
import pl.skipcode.kotlinbaseappmvvm.utils.repository.auth.AuthRepo
import pl.skipcode.kotlinbaseappmvvm.utils.repository.auth.AuthRepoInterface

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(
            service: AuthService
    ): AuthRepoInterface =
            AuthRepo(
                    service
            )

}