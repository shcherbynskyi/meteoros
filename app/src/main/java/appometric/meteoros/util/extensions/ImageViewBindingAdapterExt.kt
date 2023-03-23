package appometric.meteoros.util.extensions

import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import appometric.meteoros.R
import appometric.meteoros.feature.weather.data.model.Weather
import com.squareup.picasso.Picasso

@BindingAdapter("app:loadFlagByCountryCode")
fun ImageView.loadFlagByCountryCode(countryCode: String) {

    val url = "https://flagsapi.com/$countryCode/flat/32.png"

    Picasso.get()
        .load(url)
        .into(this)
}

@BindingAdapter("app:loadIconByWeather")
fun ImageView.loadIconByWeather(weatherList: List<Weather>) {
    val weatherIcon  = when (weatherList.firstOrNull()?.description) {
        "clear sky" -> R.drawable.ic_sunny
        "few clouds" -> R.drawable.ic_partly_cloudy
        "scattered clouds" -> R.drawable.ic_clouds
        "broken clouds" -> R.drawable.ic_partly_cloudy
        "shower rain" -> R.drawable.ic_raining
        "rain" -> R.drawable.ic_raining
        "thunderstorm" -> R.drawable.ic_thunder
        "light snow" -> R.drawable.ic_snow
        "snow" -> R.drawable.ic_snow
        "mist" -> R.drawable.ic_raining
        else -> R.drawable.ic_clouds
    }

    this.background = AppCompatResources.getDrawable(context, weatherIcon)
}