package pl.skipcode.kotlinbaseappmvvm.utils.tools.permissions

import io.reactivex.Observable

interface PermissionsHelperInterface {

    fun request(vararg permissions: String): Observable<Boolean>

}