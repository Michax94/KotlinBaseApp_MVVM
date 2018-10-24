package pl.skipcode.kotlinbaseappmvvm.feature.commons.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment: Fragment(){

    abstract val layoutId: Int

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutId, container, false)
    }

    protected inline fun <reified T : ViewModel> getViewModel(
            viewModelFactory: ViewModelProvider.Factory
    ): T = ViewModelProviders.of(this, viewModelFactory)[T::class.java]

}