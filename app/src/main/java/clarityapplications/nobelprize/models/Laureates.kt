package clarityapplications.nobelprize.models

import com.google.gson.annotations.SerializedName

data class Laureates (

    @SerializedName("id") val id : Int,
    @SerializedName("firstname") val firstname : String,
    @SerializedName("surname") val surname : String,
    @SerializedName("motivation") val motivation : String,
    @SerializedName("share") val share : Int
) {
    override fun toString(): String = "$firstname $surname"
}