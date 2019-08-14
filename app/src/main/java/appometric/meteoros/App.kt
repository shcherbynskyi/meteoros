package appometric.meteoros

import android.app.Application
import android.content.Context
import appometric.meteoros.di.component.AppComponent
import appometric.meteoros.di.component.DaggerAppComponent

class App : Application() {

    companion object {

        val GOOGLE_PACES_API_KEY = "AIzaSyBE4SE0CBdsId-TlM1jT2aXa_VmnSWmzxc"
        val OPEN_WEATHER_MAP_API_KEY = "05728203376d4b4cb9652a5b2785854e"

        private lateinit var appComponent: AppComponent
        private lateinit var appContext: Context

        fun getAppComponent(): AppComponent = appComponent
        fun getAppContext(): Context = appContext
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
        appContext = applicationContext
    }

}