package pl.skipcode.kotlinbaseappmvvm.feature.splash.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pl.skipcode.kotlinbaseappmvvm.R
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract
import pl.skipcode.kotlinbaseappmvvm.feature.splash.viewModel.SplashViewModel
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.ActivityView {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var gear: SplashContract.Gear

    override val layoutId: Int = R.layout.activity_splash
    override val frameLayoutId: Int? = null

    var viewModel: SplashViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel(viewModelFactory)
    }

    override fun onResume() {
        super.onResume()

        viewModel?.getIsLoginLiveData()?.observe(this, Observer(gear::navigate))
    }
}