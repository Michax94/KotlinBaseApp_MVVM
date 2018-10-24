package pl.skipcode.kotlinbaseappmvvm.feature.main.navigation

import pl.skipcode.kotlinbaseappmvvm.feature.commons.navigation.BaseRouter
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract

class MainRouter(
        private val activityView: MainContract.ActivityView
) : BaseRouter(activityView), MainContract.Router