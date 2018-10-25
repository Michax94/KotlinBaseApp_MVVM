package pl.skipcode.kotlinbaseappmvvm.feature.main.viewModel

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

    override val logoutLiveData = MutableLiveData<Boolean>()

    init {
        initAuthorizationObservable()
    }

    override fun viewOnCreate() = Unit

    private fun initAuthorizationObservable(){
        compositeDisposable.add(configuration.authorizationObservable()
                .subscribe {
                    configuration.logout()
                    logoutLiveData.postValue(true)
                })
    }
}