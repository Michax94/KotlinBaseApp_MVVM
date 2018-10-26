package pl.skipcode.kotlinbaseappmvvm.feature.commons.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
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

    fun <T> startActivity(
            activityClass: Class<T>,
            flags: List<Int>? = null,
            parcelable: Pair<String, Parcelable>? = null
    ) where T : BaseActivity {
        val intent = Intent(this, activityClass)
        flags?.forEach { intent.addFlags(it) }
        parcelable?.let { intent.putExtra(it.first, it.second) }
        startActivity(intent)
    }

    protected inline fun <reified T : ViewModel> getViewModel(
            viewModelFactory: ViewModelProvider.Factory
    ): T = ViewModelProviders.of(this, viewModelFactory)[T::class.java]


    override fun setFragment(fragment: Fragment, animType: ANIM){
        frameLayoutId?.let {
            setFragment(fragment, it, animType)
        }
    }

    override fun addFragment(fragment: Fragment, animType: ANIM){
        frameLayoutId?.let {
            addFragment(fragment, it, animType)
        }
    }

    override fun pushFragment(fragment: Fragment, animType: ANIM){
        frameLayoutId?.let {
            pushFragment(fragment, it, animType)
        }
    }
}