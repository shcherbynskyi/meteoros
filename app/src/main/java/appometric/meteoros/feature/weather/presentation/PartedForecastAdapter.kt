package appometric.meteoros.feature.weather.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import appometric.meteoros.databinding.ItemForecastBinding
import appometric.meteoros.feature.weather.domain.entities.CityForecastDto

class PartedForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private var items: MutableList<CityForecastDto> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForecastAdapter.ForecastViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ForecastAdapter.ForecastViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun update(list: List<CityForecastDto>) {
        items = list.toMutableList()
    }

    private inner class ForecastViewHolder(
        private var binding: ItemForecastBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(forecast: CityForecastDto) {

        }
    }
}