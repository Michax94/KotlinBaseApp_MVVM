package pl.skipcode.kotlinbaseappmvvm.feature.splash.gear

import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract

class SplashGear(
        private val router: SplashContract.Router
) : SplashContract.Gear{

    override fun navigate(isLogged: Boolean) {
        if(isLogged) router.goToMainActivity()
        else router.goToAuthActivity()
    }
}