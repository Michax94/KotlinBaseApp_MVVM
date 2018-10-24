package pl.skipcode.kotlinbaseappmvvm.feature.main.viewModel

import androidx.lifecycle.ViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel(), MainContract.ViewModel {

    override fun initialize() = Unit
}