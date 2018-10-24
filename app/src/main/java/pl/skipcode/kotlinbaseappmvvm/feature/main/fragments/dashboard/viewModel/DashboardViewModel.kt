package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.data.api.auth.ProfileResponse
import pl.skipcode.kotlinbaseappmvvm.data.liveData.ResponseLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.commons.viewModel.BaseViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.ConfigurationInterface
import pl.skipcode.kotlinbaseappmvvm.utils.network.errors.ErrorHelper
import pl.skipcode.kotlinbaseappmvvm.utils.repository.auth.AuthRepoInterface
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
        private val authRepo: AuthRepoInterface,
        private val configuration: ConfigurationInterface,
        private val compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable), DashboardContract.ViewModel {

    private lateinit var profileResponseLiveData: MutableLiveData<ResponseLiveData<ProfileResponse>>

    var username : String? = null

    override fun initialize() = Unit

    fun getProfileResponseLiveData(): LiveData<ResponseLiveData<ProfileResponse>> {
        if(!::profileResponseLiveData.isInitialized){
            profileResponseLiveData = MutableLiveData()
            callProfileRequest()
        }
        return profileResponseLiveData
    }

    private fun callProfileRequest() {
        compositeDisposable.add(
                authRepo.getProfile(configuration.userName, "K2I0-I5HG-XRQT-WNXG")
                        .subscribe(
                                {
                                    profileResponseLiveData.postValue(ResponseLiveData(it,true))
                                },
                                {
                                    val error = ErrorHelper().getError(it)
                                    profileResponseLiveData.postValue(ResponseLiveData(correct = false, message = error.message))
                                }
                        )
        )
    }
}