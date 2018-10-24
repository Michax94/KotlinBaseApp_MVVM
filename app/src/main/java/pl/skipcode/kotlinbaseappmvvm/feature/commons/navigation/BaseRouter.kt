package pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation

import android.content.Intent
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract
import pl.skipcode.kotlinbaseappmvvm.feature.splash.ui.SplashActivity

abstract class BaseRouter(
        private val activityView: BaseContract.ActivityView
) : BaseContract.Router{

    override fun finish() {
        activityView.finish()
    }

    override fun goToSplashActivity() {
        activityView.startActivity(SplashActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                ),
                null
        )
        finish()
    }

}