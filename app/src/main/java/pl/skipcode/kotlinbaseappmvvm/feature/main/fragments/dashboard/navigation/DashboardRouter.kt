package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.navigation

import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.pushFragment
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.about.ui.AboutFragment
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.DashboardContract

class DashboardRouter(
        private val activityView: MainContract.ActivityView
) : BaseRouter(activityView), DashboardContract.Router {

    override fun goToAboutFragment() {
        activityView.pushFragment(AboutFragment(), BaseActivity.ANIM.FADE_IN)
    }

}