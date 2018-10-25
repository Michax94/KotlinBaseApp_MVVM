package pl.skipcode.kotlinbaseappmvvm.utils.network.errors

import pl.skipcode.kotlinbaseappmvvm.utils.network.rest.ResponseException

class ApiErrorMapper {

    fun getError(throwable: Throwable) : ErrorModel{
        return if (throwable is ResponseException){
            ErrorModel(throwable.errorStatus, throwable.errorCode, getStatusMessage(throwable.errorStatus))
        }else{
            ErrorModel(ErrorStatus.SERVER_ERROR.code, ErrorStatus.SERVER_ERROR.code, getStatusMessage(ErrorStatus.SERVER_ERROR.code))
        }
    }

    private fun getStatusMessage(status: Int) : Int{

        return when (status) {
            ErrorStatus.SERVER_ERROR.code -> ErrorMessage.SERVER_ERROR.msg
            ErrorStatus.UNAUTHORIZED.code -> ErrorMessage.UNAUTHORIZED.msg
            ErrorStatus.NOT_FOUND.code -> ErrorMessage.NOT_FOUND.msg
            else -> ErrorMessage.SERVER_ERROR.msg
        }
    }

}