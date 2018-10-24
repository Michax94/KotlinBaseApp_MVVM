package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.about.viewModel

import io.reactivex.disposables.CompositeDisposable
import pl.skipcode.kotlinbaseappmvvm.feature.commons.viewModel.BaseViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.about.AboutContract
import javax.inject.Inject

class AboutViewModel @Inject constructor(
        private val compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable), AboutContract.ViewModel {

    override fun initialize() = Unit
}