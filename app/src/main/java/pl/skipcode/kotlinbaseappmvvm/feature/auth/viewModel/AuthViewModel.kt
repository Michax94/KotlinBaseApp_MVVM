package pl.skipcode.kotlinbaseappmvvm.feature.auth.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.data.liveData.ResponseLiveData
import pl.skipcode.kotlinbaseappmvvm.feature.auth.AuthContract
import pl.skipcode.kotlinbaseappmvvm.feature.commons.viewModel.BaseViewModel
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration
import pl.skipcode.kotlinbaseappmvvm.utils.network.errors.ApiErrorMapper
import pl.skipcode.kotlinbaseappmvvm.utils.repository.auth.AuthRepoInterface
import javax.inject.Inject

class AuthViewModel @Inject constructor(
        private val authRepo: AuthRepoInterface,
        private val configuration: IConfiguration,
        private val compositeDisposable: CompositeDisposable,
        private val apiErrorMapper: ApiErrorMapper
) : BaseViewModel(compositeDisposable), AuthContract.ViewModel{

    private lateinit var loginResponseLiveData: MutableLiveData<ResponseLiveData<Any?>>

    var username : String? = null

    override fun initialize() = Unit

    fun getLoginResponseLiveData(): LiveData<ResponseLiveData<Any?>> {
        if(!::loginResponseLiveData.isInitialized){
            loginResponseLiveData = MutableLiveData()
        }
        return loginResponseLiveData
    }

    fun callLoginRequest() {
        compositeDisposable.add(
                authRepo.loginUser(username, "K2I0-I5HG-XRQT-WNXG")
                        .subscribe(
                                {
                                    configuration.userToken = it.results[0].token
                                    configuration.userName = it.results[0].username
                                    loginResponseLiveData.postValue(ResponseLiveData(correct = true))
                                },
                                {
                                    loginResponseLiveData.postValue(ResponseLiveData(correct = false, message = apiErrorMapper.getError(it).message))
                                }
                        )
        )
    }
}