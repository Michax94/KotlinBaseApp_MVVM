package pl.skipcode.kotlinbaseappmvvm.feature.main

import androidx.lifecycle.MutableLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface MainContract {

    interface ActivityView : BaseContract.ActivityView

    interface ViewModel : BaseContract.ViewModel{
        val logoutLiveData: MutableLiveData<Boolean>
    }

    interface Router : BaseContract.Router{
        fun goToAuthActivity()
    }

    interface Gear : BaseContract.Gear{
        fun logout()
    }
}