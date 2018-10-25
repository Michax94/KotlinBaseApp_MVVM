package pl.skipcode.kotlinbaseappmvvm.feature.splash.viewModel

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.feature.commons.viewModel.BaseViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashViewModel @Inject constructor(
        private val configuration: IConfiguration,
        private val compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable), SplashContract.ViewModel{

    companion object {
        private const val TIMEOUT = 3000L
    }

    override val isLoggedLiveData = MutableLiveData<Boolean>()

    init {
        startTimer()
    }

    override fun viewOnCreate() = Unit

    private fun startTimer(){
        compositeDisposable.add(
                Observable.just(Unit)
                        .delay(TIMEOUT, TimeUnit.MILLISECONDS)
                        .subscribe(
                                { isLoggedLiveData.postValue(configuration.isUserLoggedIn()) },
                                { Timber.e(it) }
                        )
        )
    }
}