package pl.skipcode.kotlinbaseappmvvm.feature.splash.navigation

import android.content.Intent
import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract
import pl.skipcode.kotlinbaseappmvvm.feature.splash.ui.SplashActivity

class SplashRouter(
        private val activity: SplashActivity
) : SplashContract.Router, BaseRouter(activity) {


}