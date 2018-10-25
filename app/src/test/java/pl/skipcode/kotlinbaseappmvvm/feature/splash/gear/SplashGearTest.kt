package pl.skipcode.kotlinbaseappmvvm.feature.splash.gear

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import pl.skipcode.kotlinbaseappmvvm.feature.BaseTest
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract

class SplashGearTest : BaseTest() {

    @Mock
    private lateinit var router: SplashContract.Router

    private lateinit var gear: SplashContract.Gear

    override fun setup() {
        super.setup()
        gear = SplashGear(
                router
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                router
        )
    }

    @Test
    fun `should called router goToMainActivity when is logged`() {
        val isLogged = true

        gear.navigate(isLogged)

        verify(router, times(1)).goToMainActivity()
    }

    @Test
    fun `should called router goToAuthActivity when is not logged`() {
        val isLogged = false

        gear.navigate(isLogged)

       verify(router, times(1)).goToAuthActivity()
    }

}