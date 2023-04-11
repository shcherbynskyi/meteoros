package appometric.meteoros.feature.weather.data.models

import com.google.gson.annotations.SerializedName

data class LocationApiResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lon")
    val longitude: Double,
    @SerializedName("country")
    val country: String,
    @SerializedName("state")
    val state: String,
)