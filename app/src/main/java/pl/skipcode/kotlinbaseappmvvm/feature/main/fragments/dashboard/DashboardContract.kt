package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard

import pl.skipcode.kotlinbaseappmvvm.data.api.auth.ProfileResponse
import pl.skipcode.kotlinbaseappmvvm.data.liveData.ResponseLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface DashboardContract {

    interface View : BaseContract.View{
        fun setUsernameUI(username : String)
        fun showMessage(message : Int)
    }

    interface ViewModel : BaseContract.ViewModel

    interface Router : BaseContract.Router{
        fun goToAboutFragment()
    }

    interface Gear : BaseContract.Gear{
        fun doProfileResponse(response : ResponseLiveData<ProfileResponse>)
        fun openAbout()
        fun logout()
    }
}