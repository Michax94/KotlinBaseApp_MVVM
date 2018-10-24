package pl.skipcode.kotlinbaseappmvvm.data.api.auth

import com.google.gson.annotations.SerializedName

data class ResultResponse(
        @SerializedName("username")
        val username: String,
        @SerializedName("token")
        val token: String
)