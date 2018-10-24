package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.about.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import pl.skipcode.kotlinbaseappmvvm.R
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseFragment
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.about.AboutContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.viewModel.DashboardViewModel
import javax.inject.Inject

class AboutFragment : BaseFragment(), AboutContract.View{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override val layoutId: Int = R.layout.fragment_about

    var viewModel: DashboardViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(viewModelFactory)
    }
}