package pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation

import android.content.Intent
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.splash.ui.SplashActivity

abstract class BaseRouter(
        private val activity: BaseActivity
) : BaseContract.Router{

    override fun finish() {
        activity.finish()
    }

    override fun goToSplashActivity() {
        activity.startActivity(SplashActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
        finish()
    }

}