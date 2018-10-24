package pl.skipcode.kotlinbaseappmvvm.feature.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import pl.skipcode.kotlinbaseappmvvm.R
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.ui.DashboardFragment
import pl.skipcode.kotlinbaseappmvvm.feature.main.viewModel.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.ActivityView, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val layoutId: Int = R.layout.activity_main
    override val frameLayoutId: Int = R.id.fragmentContainer

    var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel(viewModelFactory)
        viewModel?.initialize()
        initFragment()
    }

    private fun initFragment(){
        setFragment(DashboardFragment(), ANIM.FADE_IN)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}