package pl.skipcode.kotlinbaseappmvvm.feature.commons

import android.os.Parcelable
import androidx.fragment.app.Fragment
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity

interface BaseContract {

    interface ActivityView{
        fun finish()
        fun <T> startActivity(
                activityClass: Class<T>,
                flags: List<Int>?,
                parcelable: Pair<String, Parcelable>?
        )
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