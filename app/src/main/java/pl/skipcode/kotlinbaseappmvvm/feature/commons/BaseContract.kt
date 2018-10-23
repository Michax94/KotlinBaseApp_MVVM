package pl.skipcode.kotlinbaseappmvvm.feature.commons

interface BaseContract {

    interface View

    interface Router

    interface Presenter {
        fun initialize()
        fun clear()
    }
}