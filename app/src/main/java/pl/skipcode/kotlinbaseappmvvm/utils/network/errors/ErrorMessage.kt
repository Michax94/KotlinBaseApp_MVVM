package pl.skipcode.kotlinbaseappmvvm.utils.network.errors

import pl.skipcode.kotlinbaseappmvvm.R


class ErrorMessage {

    companion object {
        const val SERVER_ERROR = R.string.error_api_connection_error
        const val UNAUTHORIZED = R.string.error_api_unauthorized
        const val NOT_FOUND = R.string.error_api_not_found
    }

}