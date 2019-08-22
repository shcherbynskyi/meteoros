package appometric.meteoros.di.module

import appometric.meteoros.network.WeatherMapAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    val OPEN_WEATHER_MAP_API_BASE_URL = "https://api.openweathermap.org/"


    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(OPEN_WEATHER_MAP_API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    @Singleton
    fun provideWeatherData(retrofit: Retrofit) = retrofit
        .create(WeatherMapAPI::class.java)


}