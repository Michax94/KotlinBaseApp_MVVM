package pl.skipcode.kotlinbaseappmvvm.utils.configuration

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

interface IConfiguration {
    fun isUserLoggedIn(): Boolean
    fun logout(): Unit
    var userToken: String?
    var userName: String?

    var authorizationSubject: PublishSubject<Int>
    fun authorizationObservable(): Observable<Int>

}