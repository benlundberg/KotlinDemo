package clarityapplications.nobelprize.models

import com.google.gson.annotations.SerializedName

data class Affiliations (
    @SerializedName("name") val name : String,
    @SerializedName("city") val city : String,
    @SerializedName("country") val country : String
)