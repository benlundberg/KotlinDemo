package clarityapplications.nobelprize.services

import clarityapplications.nobelprize.configs.ServiceConfig
import clarityapplications.nobelprize.models.Prizes
import clarityapplications.nobelprize.models.RootObject
import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import java.lang.Exception

class PrizeService {

    fun getPrizes() : List<Prizes> {

        // Create http client
        val httpClient = OkHttpClient()

        // Create request
        val request = Request.Builder()
            .url(ServiceConfig.GET_PRIZES)
            .build()

        // Execute and get response
        val response = httpClient.newCall(request).execute()

        try {

            val json = response.body().string()

            // Parse response json
            val rootObject = Gson().fromJson(json, RootObject::class.java)

            // Return prizes
            return rootObject.prizes

        } catch (exception: Exception) {
            throw exception
        }
    }
}