package pl.skipcode.kotlinbaseappmvvm.feature.splash.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.feature.commons.viewModel.BaseViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.ConfigurationInterface
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashViewModel @Inject constructor(
        private val configuration: ConfigurationInterface,
        private val compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable), SplashContract.ViewModel{

    companion object {
        const val TIMEOUT = 3000L
    }

    private lateinit var isLoginLiveData: MutableLiveData<Boolean>

    override fun initialize() = Unit

    fun getIsLoginLiveData(): LiveData<Boolean>{
        if(!::isLoginLiveData.isInitialized){
            isLoginLiveData = MutableLiveData()
            startTimer()
        }
        return isLoginLiveData
    }

    private fun startTimer(){
        compositeDisposable.add(
                Observable.just(Unit)
                        .delay(TIMEOUT, TimeUnit.MILLISECONDS)
                        .subscribe(
                                { isLoginLiveData.postValue(configuration.isUserLoggedIn()) },
                                { Timber.e(it) }
                        )
        )
    }
}