package clarityapplications.nobelprize.models

import com.google.gson.annotations.SerializedName

data class Laureate (

    @SerializedName("id") val id : Int,
    @SerializedName("firstname") val firstname : String,
    @SerializedName("surname") val surname : String,
    @SerializedName("motivation") val motivation : String,
    @SerializedName("share") val share : Int,
    @SerializedName("born") val born : String,
    @SerializedName("died") val died : String,
    @SerializedName("bornCountry") val bornCountry : String,
    @SerializedName("bornCountryCode") val bornCountryCode : String,
    @SerializedName("bornCity") val bornCity : String,
    @SerializedName("diedCountry") val diedCountry : String,
    @SerializedName("diedCountryCode") val diedCountryCode : String,
    @SerializedName("diedCity") val diedCity : String,
    @SerializedName("gender") val gender : String,
    @SerializedName("prizes") val prizes : List<Prize>?
) {
    override fun toString(): String = "$firstname $surname"
}