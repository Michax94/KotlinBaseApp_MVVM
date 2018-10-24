package pl.skipcode.kotlinbaseappmvvm.feature.commons.viewModel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
        private val compositeDisposable: CompositeDisposable
) : ViewModel(){

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}