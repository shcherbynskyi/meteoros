package appometric.meteoros.util.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import appometric.meteoros.R
import appometric.meteoros.model.Forecast

class ForecastAdapter(
        val context: Context,
        val items: List<Forecast>
) : RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ForecastViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_weather, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.tvCity.text = items[position].getCity()
        holder.tvCountry.text = items[position].getCountry()
        holder.tvTemperature.text = "${items[position].getTemperature()}°C"
    }

}