package pl.skipcode.kotlinbaseappmvvm

import android.app.Activity
import android.app.Application


abstract class BaseApplication : Application() /*HasActivityInjector*/ {

//    @Inject
//    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

//        Hawk.init(this).build()
//        Fabric.with(this, Crashlytics())

//        initTimber()
//        initDaggerComponent()
    }

    abstract fun initTimber()

//    private fun initDaggerComponent() {
//        DaggerAppComponent.builder()
//                .bindApplication(this)
//                .build()
//                .inject(this)
//    }

//    override fun activityInjector(): AndroidInjector<Activity> =
//            activityInjector

}