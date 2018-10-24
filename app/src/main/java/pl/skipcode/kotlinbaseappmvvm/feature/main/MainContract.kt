package pl.skipcode.kotlinbaseappmvvm.feature.main

import pl.skipcode.kotlinbaseappmvvm.feature.commons.BaseContract

interface MainContract {

    interface ActivityView : BaseContract.ActivityView

    interface ViewModel : BaseContract.ViewModel

    interface Router : BaseContract.Router
}