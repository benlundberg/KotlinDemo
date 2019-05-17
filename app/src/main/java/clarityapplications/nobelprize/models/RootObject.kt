package clarityapplications.nobelprize.models

import com.google.gson.annotations.SerializedName

data class RootObject (
    @SerializedName("prizes") val prizes : List<Prizes>
)