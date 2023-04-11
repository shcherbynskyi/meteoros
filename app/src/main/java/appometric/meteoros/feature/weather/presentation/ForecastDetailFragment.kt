package appometric.meteoros.feature.weather.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import appometric.meteoros.R
import appometric.meteoros.databinding.FragmentForecastDetailBinding
import appometric.meteoros.util.extensions.dataBinding

class ForecastDetailFragment : Fragment() {

    private val binding: FragmentForecastDetailBinding by dataBinding(R.layout.fragment_forecast_detail)
    private val viewModel: ForecastViewModel by activityViewModels()
    private val args: ForecastDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View {
        binding.forecast = args.forecast
        return binding.root
    }
}