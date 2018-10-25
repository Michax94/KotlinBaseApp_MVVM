package pl.skipcode.kotlinbaseappmvvm.feature.splash.ui

import org.mockito.Mock
import org.mockito.Mockito
import pl.skipcode.kotlinbaseappmvvm.feature.BaseTest
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract

class SplashActivityTest : BaseTest(){

    @Mock
    private lateinit var gear: SplashContract.Gear

    private lateinit var activity: SplashContract.ActivityView

    override fun setup() {
        super.setup()
        trampolineRxPlugin()
        activity = SplashActivity()
    }

    override fun tearDown() {
        super.tearDown()
        Mockito.verifyNoMoreInteractions(
                gear
        )
    }
}