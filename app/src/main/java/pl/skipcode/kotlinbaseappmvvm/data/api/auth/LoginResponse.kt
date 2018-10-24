package pl.skipcode.kotlinbaseappmvvm.data.api.auth

import com.google.gson.annotations.SerializedName

data class LoginResponse(
        @SerializedName("results")
        val results: List<ResultResponse>)
