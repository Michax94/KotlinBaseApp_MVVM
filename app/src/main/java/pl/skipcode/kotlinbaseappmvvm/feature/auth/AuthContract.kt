package pl.skipcode.kotlinbaseappmvvm.feature.auth

import pl.skipcode.kotlinbaseappmvvm.data.liveData.ResponseLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface AuthContract {

    interface ActivityView : BaseContract.ActivityView{
        fun showMessage(message : Int)
    }

    interface ViewModel : BaseContract.ViewModel

    interface Router : BaseContract.Router{
        fun goToMainActivity()
    }

    interface Gear : BaseContract.Gear{
        fun doLoginResponse(response : ResponseLiveData<Any?>)
    }
}