package appometric.meteoros

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
//        val GOOGLE_PACES_API_KEY = "AIzaSyBE4SE0CBdsId-TlM1jT2aXa_VmnSWmzxc"
        const val OPEN_WEATHER_MAP_API_KEY = "05728203376d4b4cb9652a5b2785854e"
    }
}