package pl.skipcode.kotlinbaseappmvvm.feature.splash.viewModel

import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import pl.skipcode.kotlinbaseappmvvm.feature.BaseTest
import pl.skipcode.kotlinbaseappmvvm.feature.splash.SplashContract
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.IConfiguration

class SplashViewModelTest : BaseTest(){

    @Mock
    private lateinit var configuration: IConfiguration

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var viewModel: SplashContract.ViewModel

    override fun setup() {
        super.setup()
        trampolineRxPlugin()
        viewModel = SplashViewModel(
                configuration,
                compositeDisposable
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                configuration,
                compositeDisposable
        )
    }

    @Test
    fun `should check configuration user login status when getIsLoggedLiveData is called`() {
        val isLogged = true

        `when`(configuration.isUserLoggedIn()).thenReturn(isLogged)

        viewModel.getIsLoggedLiveData()

        verify(compositeDisposable, Mockito.times(1)).add(ArgumentMatchers.any())
        verify(configuration, Mockito.times(1)).isUserLoggedIn()
    }

}