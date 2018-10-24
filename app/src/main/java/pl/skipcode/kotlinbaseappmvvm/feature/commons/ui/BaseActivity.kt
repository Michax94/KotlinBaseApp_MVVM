package pl.skipcode.kotlinbaseappmvvm.feature.commons.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import pl.skipcode.kotlinbaseappmvvm.R
import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract


abstract class BaseActivity: AppCompatActivity(), BaseContract.ActivityView{

    abstract val layoutId: Int
    abstract val frameLayoutId: Int?

    enum class ANIM {
        FADE_IN, NONE
    }

    private var frameLayout: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        if(frameLayoutId != null) {
            frameLayout = findViewById(frameLayoutId!!)
        }
    }

    override fun <T> startActivity(
            activityClass: Class<T>,
            flags: List<Int>?,
            parcelable: Pair<String, Parcelable>?) {
        val intent = Intent(this, activityClass)
        flags?.forEach { intent.addFlags(it) }
        parcelable?.let { intent.putExtra(it.first, it.second) }
        startActivity(intent)
    }

    protected inline fun <reified T : ViewModel> getViewModel(
            viewModelFactory: ViewModelProvider.Factory
    ): T = ViewModelProviders.of(this, viewModelFactory)[T::class.java]


    private fun getAnim(animType: ANIM) : List<Int> {
        return when (animType) {
            ANIM.FADE_IN -> listOf(R.anim.fade_in, R.anim.fade_out,
                    R.anim.fade_in, R.anim.fade_out)
            ANIM.NONE -> listOf()
        }
    }

    override fun setFragment(fragment: Fragment, animType: ANIM){
        setFragmentExt(fragment, animType)
    }

    override fun addFragment(fragment: Fragment, animType: ANIM){
        addFragmentExt(fragment, animType)
    }

    override fun replaceFragment(fragment: Fragment, animType: ANIM){
        replaceFragmentExt(fragment, animType)
    }

    private fun AppCompatActivity.setFragmentExt(fragment: Fragment, animType: ANIM){
        if (frameLayoutId == null) return

        while (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        }
        supportFragmentManager.inTransaction ({ replace(frameLayoutId!!, fragment) }, animType)
    }

    private fun AppCompatActivity.addFragmentExt(fragment: Fragment, animType: ANIM){
        if (frameLayoutId == null) return
        val backStateName = fragment.javaClass.name
        supportFragmentManager.inTransaction ({ add(frameLayoutId!!, fragment).addToBackStack(backStateName) }, animType)
    }

    private fun AppCompatActivity.replaceFragmentExt(fragment: Fragment, animType: ANIM) {
        if (frameLayoutId == null) return
        val backStateName = fragment.javaClass.name
        supportFragmentManager.inTransaction ({ replace(frameLayoutId!!, fragment).addToBackStack(backStateName) }, animType)
    }

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction, animType: ANIM) {
        if (animType != ANIM.NONE) {
            beginTransaction().func().commitAllowingStateLoss()
        }else{
            beginTransaction()
                    .func()
                    .setCustomAnimations(getAnim(animType)[0], getAnim(animType)[1], getAnim(animType)[2], getAnim(animType)[3])
                    .commitAllowingStateLoss()
        }
    }
}