package pl.skipcode.kotlinbaseappmvvm.feature.main.navigation

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import pl.skipcode.kotlinbaseappmvvm.feature.auth.ui.AuthActivity
import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract


class MainRouter (
        private val activity: BaseActivity
) : BaseRouter(activity), MainContract.Router{

    override fun goToAuthActivity() {
        activity.startActivity(AuthActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }

    override fun goToAppSettings() {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        val uri = Uri.fromParts("package", activity.packageName, null)
        intent.data = uri
        activity.startActivity(intent)
    }

}