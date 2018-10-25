package pl.skipcode.kotlinbaseappmvvm.feature.main.gear

import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract

class MainGear(
        private val router: MainContract.Router
) : MainContract.Gear{

    override fun logout() {
        router.goToAuthActivity()
    }
}