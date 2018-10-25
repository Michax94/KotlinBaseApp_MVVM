package pl.skipcode.kotlinbaseappmvvm.utils.network.errors

enum class ErrorStatus(val code : Int) {
    SERVER_ERROR(500),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404)
}