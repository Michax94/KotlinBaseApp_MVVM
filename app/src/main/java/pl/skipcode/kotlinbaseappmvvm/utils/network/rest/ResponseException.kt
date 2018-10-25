package pl.skipcode.kotlinbaseappmvvm.utils.network.rest

class ResponseException(code : Int, status : Int, message : String? = null) : Exception(){

    val errorCode : Int = code
    val errorStatus : Int = status
    val errorMessage : String? = message

}