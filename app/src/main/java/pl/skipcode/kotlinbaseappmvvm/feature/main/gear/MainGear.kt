package pl.skipcode.kotlinbaseappmvvm.feature.main.gear

import android.Manifest
import androidx.appcompat.app.AlertDialog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.skipcode.kotlinbaseappmvvm.R
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.utils.tools.permissions.IPermissionsHelper

class MainGear(
        private val activity: BaseActivity,
        private val router: MainContract.Router,
        private val permissionHelper: IPermissionsHelper
) : MainContract.Gear{

    private var permissionRequestExists : Boolean = false

    override fun logout() {
        router.goToAuthActivity()
    }

    override fun getCameraPermissionObservable() : Observable<Boolean>? {
        if(permissionRequestExists) {
            return null
        } else {
            permissionRequestExists = true
            return permissionHelper
                    .request(Manifest.permission.CAMERA)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext {
                        if (!it) {
                            getSettingsAlert()?.show()
                        }else{
                            permissionRequestExists = false
                        }
                    }
                    .filter { it }
        }
    }

    private fun getSettingsAlert() : AlertDialog? {
        return activity.let { it ->
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(R.string.settings) { dialog, id -> router.goToAppSettings()
                }
                setNegativeButton(R.string.cancel) { dialog, id -> router.finish()
                }
            }
            builder.setMessage(R.string.permission_rationale)
                    .setCancelable(false)
                    .setOnDismissListener {
                        permissionRequestExists = false
                    }
            builder.create()
        }
    }
}