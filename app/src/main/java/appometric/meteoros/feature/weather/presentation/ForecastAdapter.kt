package appometric.meteoros.feature.weather.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import appometric.meteoros.R
import appometric.meteoros.databinding.ItemForecastBinding
import appometric.meteoros.feature.weather.data.models.ForecastApiResponse
import appometric.meteoros.feature.weather.domain.entities.CityForecastDto

class ForecastAdapter(
    val onItemClick: (forecast: CityForecastDto) -> Unit
) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private var items: MutableList<CityForecastDto> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder =
        ForecastViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_forecast,
                parent,
                false
            )
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) =
        holder.bind(items[position])

    fun update(list: List<CityForecastDto>) {
        items = list.toMutableList()
    }

    fun add(forecast: CityForecastDto) {
        items.add(forecast)
        notifyDataSetChanged()
    }

    inner class ForecastViewHolder(var binding: ItemForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(forecast: CityForecastDto) {
            binding.forecast = forecast
            binding.root.setOnClickListener { onItemClick(forecast) }
        }
    }
}