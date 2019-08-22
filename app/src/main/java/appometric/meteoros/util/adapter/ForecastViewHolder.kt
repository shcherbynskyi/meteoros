package appometric.meteoros.util.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_weather.view.*

class ForecastViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var ivWeatherIcon = view.iv_icon
    val tvCity = view.tv_city
    val ivCountry = view.iv_country
    val tvTemperature = view.tv_temperature
}