package appometric.meteoros.feature.weather.data.models

import com.google.gson.annotations.SerializedName

data class PartedForecastApiResponse(
    @SerializedName("list")
    val partedForecastForFiveDays: List<ForecastApiResponse>
)