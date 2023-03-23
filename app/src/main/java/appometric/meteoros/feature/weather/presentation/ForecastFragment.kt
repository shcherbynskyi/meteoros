package appometric.meteoros.feature.weather.presentation

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import appometric.meteoros.R
import appometric.meteoros.databinding.FragmentForecastBinding
import appometric.meteoros.util.extensions.dataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastFragment : Fragment() {

    private val binding: FragmentForecastBinding by dataBinding(R.layout.fragment_forecast)
    private val viewModel: ForecastViewModel by activityViewModels()
    private val forecastAdapter: ForecastAdapter = ForecastAdapter { openForecastDetail() }

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvWeather.adapter = forecastAdapter
        binding.buttonAddForecast.setOnClickListener { openAddForecastDialog() }

        viewModel.forecast.observe(viewLifecycleOwner) { forecast -> forecastAdapter.add(forecast) }
    }

    private fun openForecastDetail() {
        // TODO implement click action for forecast item - it should open forecast details
    }

    private fun openAddForecastDialog() = AddForecastDialog(
        passedContext = requireContext(),
        onPositiveClick = { cityName ->
            viewModel.fetchForecastByCityName(cityName)
        }
    ).show(parentFragmentManager, null)
}