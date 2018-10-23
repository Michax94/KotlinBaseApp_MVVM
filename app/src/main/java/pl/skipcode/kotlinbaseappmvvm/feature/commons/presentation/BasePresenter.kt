package pl.skipcode.kotlinbaseappmvvm.feature.commons.presentation

import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

abstract class BasePresenter(
        private val compositeDisposable: CompositeDisposable
) : BaseContract.Presenter{

    override fun clear() {
        compositeDisposable.clear()
    }
}