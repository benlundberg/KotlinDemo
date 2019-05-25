package clarityapplications.nobelprize.models

import com.google.gson.annotations.SerializedName

data class Prize(

    @SerializedName("year") val year: Int,
    @SerializedName("category") val category: String,
    @SerializedName("overallMotivation") val overallMotivation: String,
    @SerializedName("laureates") val laureates: List<Laureate>?,
    @SerializedName("motivation") val motivation: String
)

