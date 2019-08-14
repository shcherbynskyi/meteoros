package appometric.meteoros.util.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_weather.view.*

class ForecastViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvCity = view.tv_city
    val tvCountry = view.tv_country
    val tvTemperature = view.tv_temperature
}
