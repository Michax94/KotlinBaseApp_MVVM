package pl.skipcode.kotlinbaseappmvvm.feature.commons.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import pl.skipcode.kotlinbaseappmvvm.R

fun AppCompatActivity.setFragment(fragment: Fragment, frameLayoutId: Int, animType: BaseActivity.ANIM = BaseActivity.ANIM.NONE){
    while (supportFragmentManager.backStackEntryCount > 0) {
        supportFragmentManager.popBackStackImmediate()
    }
    supportFragmentManager.inTransaction ({ replace(frameLayoutId, fragment) }, animType)
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameLayoutId: Int, animType: BaseActivity.ANIM = BaseActivity.ANIM.NONE){
    val backStateName = fragment.javaClass.name
    supportFragmentManager.inTransaction ({ add(frameLayoutId, fragment).addToBackStack(backStateName) }, animType)
}

fun AppCompatActivity.pushFragment(fragment: Fragment, frameLayoutId: Int, animType: BaseActivity.ANIM = BaseActivity.ANIM.NONE) {
    val backStateName = fragment.javaClass.name
    supportFragmentManager.inTransaction ({ replace(frameLayoutId, fragment).addToBackStack(backStateName) }, animType)
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction, animType: BaseActivity.ANIM) {
    if (animType != BaseActivity.ANIM.NONE) {
        beginTransaction().func().commitAllowingStateLoss()
    }else{
        beginTransaction()
                .func()
                .setCustomAnimations(getAnim(animType)[0], getAnim(animType)[1], getAnim(animType)[2], getAnim(animType)[3])
                .commitAllowingStateLoss()
    }
}

fun getAnim(animType: BaseActivity.ANIM) : List<Int> {
    return when (animType) {
        BaseActivity.ANIM.FADE_IN -> listOf(R.anim.fade_in, R.anim.fade_out,
                R.anim.fade_in, R.anim.fade_out)
        BaseActivity.ANIM.NONE -> listOf()
    }
}