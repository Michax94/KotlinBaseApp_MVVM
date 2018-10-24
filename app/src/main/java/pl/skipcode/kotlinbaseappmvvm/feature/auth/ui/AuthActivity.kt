package pl.skipcode.kotlinbaseappmvvm.feature.auth.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_auth.*
import pl.skipcode.kotlinbaseappmvvm.R
import pl.skipcode.kotlinbaseappmvvm.feature.auth.AuthContract
import pl.skipcode.kotlinbaseappmvvm.feature.auth.viewModel.AuthViewModel
import pl.skipcode.kotlinbaseappmvvm.feature.commons.ui.BaseActivity
import javax.inject.Inject

class AuthActivity : BaseActivity(), AuthContract.ActivityView {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var gear: AuthContract.Gear

    override val layoutId: Int = R.layout.activity_auth
    override val frameLayoutId: Int? = null

    var viewModel: AuthViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel(viewModelFactory)

        initUI()
        initObservers()
    }

    private fun initUI(){
        btnLogin.setOnClickListener {
            viewModel?.username = etUsername.text.toString()
            viewModel?.callLoginRequest()
        }
    }

    private fun initObservers(){
        viewModel?.getLoginResponseLiveData()?.observe(this, Observer(gear::doLoginResponse))
    }

    override fun showMessage(message : Int){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}