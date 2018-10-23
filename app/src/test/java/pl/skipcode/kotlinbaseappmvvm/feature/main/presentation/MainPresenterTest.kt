package pl.skipcode.kotlinbaseappmvvm.feature.main.presentation

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import pl.skipcode.kotlinbaseappmvvm.feature.main.MainContract
import pl.skipcode.kotlinbaseappmvvm.feature.splash.BaseTest
import pl.skipcode.kotlinbaseappmvvm.utils.configuration.Configuration

class MainPresenterTest : BaseTest(){

    @Mock
    private lateinit var router: MainContract.Router

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var configuration: Configuration

    private lateinit var presenter: MainContract.Presenter

    override fun setup(){
        super.setup()
        trampolineRxPlugin()
        presenter = MainPresenter(
                router,
                compositeDisposable,
                configuration
        )
    }

    override fun tearDown(){
        super.tearDown()
        Mockito.verifyNoMoreInteractions(
                router,
                compositeDisposable,
                configuration
        )
    }

    @Test
    fun `should logout and start auth activity when auth observable return error`() {
        `when`(configuration.authorizationObservable()).thenReturn(Observable.just(5))

        presenter.initialize()

        Mockito.verify(compositeDisposable, Mockito.times(1)).add(ArgumentMatchers.any())
        Mockito.verify(configuration, Mockito.times(1)).authorizationObservable()
        Mockito.verify(configuration, Mockito.times(1)).logout()
        Mockito.verify(router, Mockito.times(1)).goToAuthActivity()

    }

    @Test
    fun `should clear composite when clear is called`(){
        presenter.clear()
        Mockito.verify(compositeDisposable, Mockito.times(1)).clear()
    }

}