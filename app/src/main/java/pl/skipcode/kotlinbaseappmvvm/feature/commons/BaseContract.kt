package pl.skipcode.kotlinbaseappmvvm.feature.commons

import androidx.fragment.app.Fragment
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity

interface BaseContract {

    interface ActivityView{
        fun finish()
        fun setFragment(fragment: Fragment, animType: BaseActivity.ANIM)
        fun addFragment(fragment: Fragment, animType: BaseActivity.ANIM)
        fun pushFragment(fragment: Fragment, animType: BaseActivity.ANIM)
    }

    interface View

    interface Gear

    interface ViewModel {
        fun viewOnCreate()
    }

    interface Router {
        fun finish()
        fun goToSplashActivity()
    }
}