package com.example.wheatherappcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.wheatherappcompose.ui.theme.WheatherAppComposeTheme
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WheatherAppComposeTheme {
                val listday = remember {
                    mutableStateOf(listOf<ItemWeatherModel>())
                }
                getData("Moscow", this, listday)
                Image(
                    painter = painterResource(R.drawable.weather),
                    contentDescription = "",
                    Modifier.fillMaxSize().alpha(0.8f),
                    contentScale = ContentScale.Crop

                )
                Column {
                    MainScreen()
                    TabLayout(listday)
                }


            }
        }
    }
}
private fun getData(city: String, context: Context, dayslist: MutableState<List<ItemWeatherModel>>) {
val url = "https://api.weatherapi.com/v1/forecast.json?key=13e8cfeba74240938e6101745250704&q=Moscow&days=3&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
    {
        response ->
        val list = getWeatherByDays(response)
        dayslist.value = list
    },
    {
        Log.d("MyLog", "Volley Error $it")
    }
    )
    queue.add(stringRequest)
}
private fun getWeatherByDays(response: String): List<ItemWeatherModel> {
    if(response.isEmpty()) return listOf()
    val list = ArrayList<ItemWeatherModel>()
    val mainJsonResponse = JSONObject(response)
    val city = mainJsonResponse.getJSONObject("location").getString("name")
    val days = mainJsonResponse.getJSONObject("forecast").getJSONArray("forecastday")

    for (i in 0 until days.length()) {
        val item = days[i] as JSONObject
        list.add(
            ItemWeatherModel(
                city,
                item.getString("date"),
                "",
                item.getJSONObject("day").getJSONObject("condition").getString("text"),
                item.getJSONObject("day").getJSONObject("condition").getString("icon"),
                item.getJSONObject("day").getString("maxtemp_c"),
                item.getJSONObject("day").getString("mintemp_c"),
                item.getJSONArray("hour").toString()
                )
        )
    }
    list[0] = list[0].copy(
        time = mainJsonResponse.getJSONObject("current").getString("last_updated"),
        currentTemp = mainJsonResponse.getJSONObject("current").getString("temp_c"),
    )
return list
}



