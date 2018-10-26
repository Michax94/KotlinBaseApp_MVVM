package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.navigation

import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.about.ui.AboutFragment
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.DashboardContract

class DashboardRouter(
        private val activity: BaseActivity
) : BaseRouter(activity), DashboardContract.Router {

    override fun goToAboutFragment() {
        activity.pushFragment(AboutFragment(), BaseActivity.ANIM.FADE_IN)
    }

}