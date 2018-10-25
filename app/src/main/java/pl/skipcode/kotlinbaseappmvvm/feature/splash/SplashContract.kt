package pl.skipcode.kotlinbaseappmvvm.feature.splash

import androidx.lifecycle.MutableLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface SplashContract {

    interface ActivityView : BaseContract.ActivityView

    interface ViewModel : BaseContract.ViewModel{
        val isLoggedLiveData: MutableLiveData<Boolean>
    }

    interface Router : BaseContract.Router{
        fun goToMainActivity()
        fun goToAuthActivity()
    }

    interface Gear : BaseContract.Gear{
        fun navigate(isLogged : Boolean)
    }
}