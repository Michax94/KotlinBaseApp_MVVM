package pl.skipcode.kotlinbaseappmvvm.feature.splash

import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface SplashContract {

    interface View : BaseContract.View

    interface Router : BaseContract.Router

    interface Presenter : BaseContract.Presenter {
        fun visible()
        fun hide()
    }
}