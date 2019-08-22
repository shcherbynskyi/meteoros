package appometric.meteoros.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/*
class RetrofitClient {

    companion object {

        private var retrofit: Retrofit? = null

        fun getWeatherMapAPI(): WeatherMapAPI {
            if (retrofit == null)
                retrofit = Retrofit.Builder()
                        .baseUrl("https://api.openweathermap.org/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

            return retrofit!!.create(WeatherMapAPI::class.java)
        }

    }

}
*/