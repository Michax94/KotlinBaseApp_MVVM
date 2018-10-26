package pl.skipcode.kotlinbaseappmvvm.feature.main

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface MainContract {

    interface ActivityView : BaseContract.ActivityView

    interface ViewModel : BaseContract.ViewModel{
        val logoutLiveData: MutableLiveData<Boolean>
        fun checkCameraPermission(observable: Observable<Boolean>)
    }

    interface Router : BaseContract.Router{
        fun goToAuthActivity()
        fun goToAppSettings()
    }

    interface Gear : BaseContract.Gear{
        fun logout()
        fun getCameraPermissionObservable() : Observable<Boolean>?
    }
}