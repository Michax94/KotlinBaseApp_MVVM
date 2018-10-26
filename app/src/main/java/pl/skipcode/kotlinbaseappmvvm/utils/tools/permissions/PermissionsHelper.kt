package pl.skipcode.kotlinbaseappmvvm.utils.tools.permissions

import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity

class PermissionsHelper(
        private val activity: BaseActivity
) : IPermissionsHelper {
    override fun request(vararg permissions: String): Observable<Boolean> {
        return RxPermissions(activity)
                .request(*permissions)
    }
}