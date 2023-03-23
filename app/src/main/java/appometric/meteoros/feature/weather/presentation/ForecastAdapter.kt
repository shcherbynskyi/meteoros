package appometric.meteoros.feature.weather.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import appometric.meteoros.R
import appometric.meteoros.databinding.ItemForecastBinding
import appometric.meteoros.feature.weather.data.model.ForecastDto

class ForecastAdapter(
    val onItemClick: () -> Unit
) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private var items: MutableList<ForecastDto> = mutableListOf()

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

    fun update(list: List<ForecastDto>) {
        items = list.toMutableList()
    }

    fun add(forecast: ForecastDto) {
        items.add(forecast)
        notifyDataSetChanged()
    }

    inner class ForecastViewHolder(var binding: ItemForecastBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(forecast: ForecastDto) {
            binding.forecast = forecast
            binding.root.setOnClickListener { onItemClick() }
        }
    }
}