package pl.skipcode.kotlinbaseappmvvm.feature.splash.navigation

import android.content.Intent
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import pl.skipcode.kotlinbaseappmvvm.feature.BaseTest
import pl.skipcode.kotlinbaseappmvvm.feature.auth.ui.AuthActivity
import pl.skipcode.kotlinbaseappmvvm.feature.main.ui.MainActivity
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract

class SplashRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: SplashContract.ActivityView

    private lateinit var router: SplashContract.Router

    override fun setup() {
        super.setup()
        router = SplashRouter(
                activity
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                activity
        )
    }

    @Test
    fun `should navigate to auth activity when goToAuthActivity is called`() {
        router.goToAuthActivity()

        verify(activity, times(1)).startActivity(
                AuthActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                ),
                null
        )
        verify(activity, times(1)).finish()
    }

    @Test
    fun `should navigate to main activity when goToMainActivity is called`() {
        router.goToMainActivity()

        verify(activity, times(1)).startActivity(
                MainActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                ),
                null
        )
        verify(activity, times(1)).finish()
    }
}