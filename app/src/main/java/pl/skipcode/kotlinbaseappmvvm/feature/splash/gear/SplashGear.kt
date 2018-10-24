package pl.skipcode.kotlinbaseappmvvm.feature.splash.gear

import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract

class SplashGear(
        private val router: SplashContract.Router
) : SplashContract.Gear{

    override fun navigate(isLogin: Boolean) {
        if(isLogin) router.goToMainActivity()
        else router.goToAuthActivity()
    }
}