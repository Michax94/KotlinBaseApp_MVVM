package pl.skipcode.kotlinbaseappmvvm.feature.splash.navigation

import android.content.Intent
import pl.skipcode.kotlinbaseappmvvm.feature.auth.ui.AuthActivity
import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.main.ui.MainActivity
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract

class SplashRouter (
        private val activity: BaseActivity
) : BaseRouter(activity), SplashContract.Router {

    override fun goToMainActivity() {
        activity.startActivity(MainActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }

    override fun goToAuthActivity() {
        activity.startActivity(AuthActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }

}