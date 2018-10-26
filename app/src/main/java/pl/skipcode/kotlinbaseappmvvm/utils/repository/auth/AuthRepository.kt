package pl.skipcode.kotlinbaseappmvvm.utils.repository.auth

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.skipcode.kotlinbaseappmvvm.data.api.auth.LoginResponse
import pl.skipcode.kotlinbaseappmvvm.data.api.auth.ProfileResponse
import pl.skipcode.kotlinbaseappmvvm.utils.network.services.AuthService

class AuthRepository(
       private val authService: AuthService
) : IAuthRepository{

    override fun loginUser(username: String?, key: String): Single<LoginResponse> {
        return authService.loginUser(username, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getProfile(username: String?, key: String): Single<ProfileResponse> {
        return authService.getProfile(username, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}