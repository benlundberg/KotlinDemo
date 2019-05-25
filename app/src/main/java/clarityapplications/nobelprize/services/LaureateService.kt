package clarityapplications.nobelprize.services

import clarityapplications.nobelprize.configs.ServiceConfig
import clarityapplications.nobelprize.models.Laureate
import clarityapplications.nobelprize.models.RootObject
import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.google.gson.reflect.TypeToken



class LaureateService {

    fun getLaureates() : List<Laureate> {

        val httpClient = OkHttpClient()

        val request = Request.Builder()
            .url(ServiceConfig.GET_LAUREATES)
            .build()

        val response = httpClient.newCall(request).execute()

        try {

            val json = response.body().string()

            val rootObject = Gson().fromJson(json, RootObject::class.java)

            return rootObject.laureates

        } catch (exception: Exception) {
            throw exception
        }
    }
}