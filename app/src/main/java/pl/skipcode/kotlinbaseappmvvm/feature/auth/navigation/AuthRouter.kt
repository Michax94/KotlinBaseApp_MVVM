package pl.skipcode.kotlinbaseappmvvm.feature.auth.navigation

import android.content.Intent
import pl.skipcode.kotlinbaseappmvvm.feature.auth.AuthContract
import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.main.ui.MainActivity

class AuthRouter (
        private val activity: BaseActivity
) : BaseRouter(activity), AuthContract.Router {

    override fun goToMainActivity() {
        activity.startActivity(MainActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }

}