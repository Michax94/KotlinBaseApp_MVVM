package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.gear

import pl.skipcode.kotlinbaseappmvvm.data.api.auth.ProfileResponse
import pl.skipcode.kotlinbaseappmvvm.data.liveData.ResponseLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration

class DashboardGear(
        private val view: DashboardContract.View,
        private val configuration: IConfiguration,
        private val router: DashboardContract.Router,
        private val routerMain: MainContract.Router
) : DashboardContract.Gear{

    override fun openAbout() = router.goToAboutFragment()

    override fun doProfileResponse(response : ResponseLiveData<ProfileResponse>){
        if(response.message != null) view.showMessage(response.message)

        if(response.correct && response.data != null){
            view.setUsernameUI(response.data.results[0].username)
        }
    }

    override fun logout() {
        configuration.logout()
        routerMain.goToSplashActivity()
    }
}