package pl.skipcode.kotlinbaseappmvvm.utils.network.services

import io.reactivex.Single
import pl.skipcode.kotlinbaseappmvvm.data.api.auth.LoginResponse
import pl.skipcode.kotlinbaseappmvvm.data.api.auth.ProfileResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthService {

    @GET("q3u20biq")
    fun loginUser(@Query("username") username: String?, @Query("key") key: String):
            Single<LoginResponse>

    @GET("q3u20biq")
    fun getProfile(@Query("username") username: String?, @Query("key") key: String):
            Single<ProfileResponse>

}