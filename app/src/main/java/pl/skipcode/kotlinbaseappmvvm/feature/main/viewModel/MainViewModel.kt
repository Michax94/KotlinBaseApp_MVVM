package pl.skipcode.kotlinbaseappmvvm.feature.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration
import javax.inject.Inject

class MainViewModel @Inject constructor(
        private val compositeDisposable: CompositeDisposable,
        private val configuration: IConfiguration
) : ViewModel(), MainContract.ViewModel {

    private lateinit var logoutLiveData: MutableLiveData<Boolean>

    override fun initialize(){
        compositeDisposable.add(configuration.authorizationObservable()
                .subscribe {
                    configuration.logout()
                    logoutLiveData.postValue(true)
                })
    }

    override fun getLogoutLiveData(): LiveData<Boolean> {
        if(!::logoutLiveData.isInitialized){
            logoutLiveData = MutableLiveData()
        }
        return logoutLiveData
    }
}