package clarityapplications.nobelprize.models

import com.google.gson.annotations.SerializedName

data class RootObject (
    @SerializedName("prizes") val prizes : List<Prize>,
    @SerializedName("laureates") val laureates : List<Laureate>
)