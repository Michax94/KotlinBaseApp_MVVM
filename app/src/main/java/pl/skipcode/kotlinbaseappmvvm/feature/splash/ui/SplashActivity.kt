package pl.skipcode.kotlinbaseappmvvm.feature.splash.ui

import android.os.Bundle
import pl.skipcode.kotlinbaseappmvvm.R
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract

class SplashActivity : SplashContract.View, BaseActivity() {

//    @Inject
//    lateinit var presenter: SplashContract.Presenter

    override val layoutId: Int = R.layout.activity_splash
    override val frameLayoutId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}