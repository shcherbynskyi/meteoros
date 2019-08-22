package appometric.meteoros.util.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import appometric.meteoros.R
import appometric.meteoros.extensions.truncate
import appometric.meteoros.model.Forecast
import com.squareup.picasso.Picasso

class ForecastAdapter(
        val context: Context,
        val items: List<Forecast>
) : RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ForecastViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_weather, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        /*
        holder.ivWeatherIcon.setImageResource(items[position].getWeatherIcon())
        holder.tvCity.text = items[position].getCity().truncate()

        Picasso.get()
            .load("https://www.countryflags.io/${items[position].getCountry()}/flat/64.png")
            .into(holder.ivCountry)

        holder.tvTemperature.text = "${items[position].getTemperature()}°C"
        */
    }

}