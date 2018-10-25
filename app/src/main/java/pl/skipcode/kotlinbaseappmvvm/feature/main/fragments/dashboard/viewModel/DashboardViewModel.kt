package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.viewModel

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.data.api.auth.ProfileResponse
import pl.skipcode.kotlinbaseappmvvm.data.liveData.ResponseLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.commons.viewModel.BaseViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration
import pl.skipcode.kotlinbaseappmvvm.utils.network.errors.ApiErrorMapper
import pl.skipcode.kotlinbaseappmvvm.utils.repository.auth.AuthRepoInterface
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
        private val authRepo: AuthRepoInterface,
        private val configuration: IConfiguration,
        private val compositeDisposable: CompositeDisposable,
        private val apiErrorMapper: ApiErrorMapper
) : BaseViewModel(compositeDisposable), DashboardContract.ViewModel {

    override var profileResponseLiveData = MutableLiveData<ResponseLiveData<ProfileResponse>>()

    var username : String? = null

    override fun viewOnCreate() = Unit

    init {
        callProfileRequest()
    }

    private fun callProfileRequest() {
        compositeDisposable.add(
                authRepo.getProfile(configuration.userName, "K2I0-I5HG-XRQT-WNXG")
                        .subscribe(
                                {
                                    profileResponseLiveData.postValue(ResponseLiveData(it,true))
                                },
                                {
                                    profileResponseLiveData.postValue(ResponseLiveData(
                                            correct = false,
                                            message = apiErrorMapper.getError(it).message)
                                    )
                                }
                        )
        )
    }
}