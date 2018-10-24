package pl.skipcode.kotlinbaseappmvvm.feature.auth.gear

import pl.skipcode.kotlinbaseappmvvm.data.liveData.ResponseLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.auth.AuthContract

class AuthGear(
        private val activityView: AuthContract.ActivityView,
        private val router: AuthContract.Router
        ) : AuthContract.Gear{

    override fun doLoginResponse(response : ResponseLiveData<Any?>){
        if(response.message != null) activityView.showMessage(response.message)

        if(response.correct){
            router.goToMainActivity()
        }
    }

}