package pl.skipcode.kotlinbaseappmvvm.feature.main.navigation

import android.content.Intent
import pl.skipcode.kotlinbaseappmvvm.feature.auth.ui.AuthActivity
import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract

class MainRouter (
        private val activityView: MainContract.ActivityView
) : BaseRouter(activityView), MainContract.Router{

    override fun goToAuthActivity() {
        activityView.startActivity(AuthActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                ),
                null
        )
        finish()
    }

}