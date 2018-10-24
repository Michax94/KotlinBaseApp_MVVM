package pl.skipcode.kotlinbaseappmvvm.feature.auth.navigation

import android.content.Intent
import pl.skipcode.kotlinbaseappmvvm.feature.auth.AuthContract
import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.main.ui.MainActivity

class AuthRouter (
        private val activityView: AuthContract.ActivityView
) : BaseRouter(activityView), AuthContract.Router {

    override fun goToMainActivity() {
        activityView.startActivity(MainActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                ),
                null
        )
        finish()
    }

}