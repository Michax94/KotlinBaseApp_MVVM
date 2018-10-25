package pl.skipcode.kotlinbaseappmvvm.utils.network.rest

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import pl.skipcode.kotlinbaseappmvvm.data.api.error.ErrorResponse
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration
import pl.skipcode.kotlinbaseappmvvm.utils.network.errors.ErrorStatus


class ResponseInterceptor(
        private val configuration: IConfiguration,
        private val gson: Gson
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val response = chain.proceed(request)
        val body = response.body()

        var errorCode = 0
        val errorStatus = response.code()

        if (errorStatus >= 400) {

            if (errorStatus == ErrorStatus.UNAUTHORIZED.code){
                configuration.authorizationSubject.onNext(ErrorStatus.UNAUTHORIZED.code)
            }

            body?.let {
                val content = body.source().buffer().readUtf8()
                val errorResponse = gson.fromJson(content, ErrorResponse::class.java)

                throw ResponseException(errorCode, errorStatus, errorResponse.error)
            }

            throw ResponseException(errorCode, errorStatus)
        }

        return response
    }
}