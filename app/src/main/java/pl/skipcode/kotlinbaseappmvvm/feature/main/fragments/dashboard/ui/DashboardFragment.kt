package pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_dashboard.*
import pl.skipcode.kotlinbaseappmvvm.R
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseFragment
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.DashboardContract
import pl.skipcode.kotlinbaseappmvvm.feature.main.fragments.dashboard.viewModel.DashboardViewModel
import javax.inject.Inject

class DashboardFragment : BaseFragment(), DashboardContract.View{

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    @Inject
    lateinit var gear: DashboardContract.Gear

    override val layoutId: Int = R.layout.fragment_dashboard

    var viewModel: DashboardViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel(viewModelFactory)

        initUI()
        initObservers()
    }

    private fun initUI(){
        btnLogout.setOnClickListener {
            gear.logout()
        }

        tvUsername.setOnClickListener{
            gear.openAbout()
        }
    }

    private fun initObservers(){
        viewModel?.profileResponseLiveData?.observe(this, Observer(gear::doProfileResponse))
    }

    override fun setUsernameUI(username : String){
        tvUsername.text = username
    }

    override fun showMessage(message : Int){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}