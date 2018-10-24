package pl.skipcode.kotlinbaseappmvvm.feature.splash

import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface SplashContract {

    interface ActivityView : BaseContract.ActivityView

    interface ViewModel : BaseContract.ViewModel

    interface Router : BaseContract.Router{
        fun goToMainActivity()
        fun goToAuthActivity()
    }

    interface Gear : BaseContract.Gear{
        fun navigate(isLogin : Boolean)
    }
}