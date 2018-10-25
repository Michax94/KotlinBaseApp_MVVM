package pl.skipcode.kotlinbaseappmvvm.utils.network.errors

import pl.skipcode.kotlinbaseappmvvm.R


enum class ErrorMessage(val msg: Int) {
    SERVER_ERROR(R.string.error_api_connection_error),
    UNAUTHORIZED(R.string.error_api_unauthorized),
    NOT_FOUND(R.string.error_api_not_found)
}