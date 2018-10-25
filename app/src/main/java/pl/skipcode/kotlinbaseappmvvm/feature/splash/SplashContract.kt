package pl.skipcode.kotlinbaseappmvvm.feature.splash

import androidx.lifecycle.LiveData
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface SplashContract {

    interface ActivityView : BaseContract.ActivityView

    interface ViewModel : BaseContract.ViewModel{
        fun getIsLoggedLiveData(): LiveData<Boolean>
    }

    interface Router : BaseContract.Router{
        fun goToMainActivity()
        fun goToAuthActivity()
    }

    interface Gear : BaseContract.Gear{
        fun navigate(isLogin : Boolean)
    }
}