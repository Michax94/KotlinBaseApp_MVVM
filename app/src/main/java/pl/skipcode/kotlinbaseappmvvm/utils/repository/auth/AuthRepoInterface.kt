package pl.skipcode.kotlinbaseappmvvm.utils.repository.auth

import io.reactivex.Single
import pl.skipcode.kotlinbaseappmvvm.data.api.auth.LoginResponse
import pl.skipcode.kotlinbaseappmvvm.data.api.auth.ProfileResponse

interface AuthRepoInterface {

    fun loginUser(username : String?, key : String) : Single<LoginResponse>

    fun getProfile(username : String?, key : String) : Single<ProfileResponse>

}