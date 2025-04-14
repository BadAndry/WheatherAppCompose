package com.example.wheatherappcompose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wheatherappcompose.R
import com.example.wheatherappcompose.data.ItemWeatherModel
import com.example.wheatherappcompose.ui.theme.BlueLow


@Composable
fun MainScreen(currentDay: MutableState<ItemWeatherModel>, onSyncClick: () -> Unit, onSearchClick: () -> Unit) {
    Column(modifier = Modifier.padding(top = 25.dp),
        )

    {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = BlueLow),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            shape = RoundedCornerShape(5.dp)
        )
        {
            Column(Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally)

            {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                        text = currentDay.value.time,
                        style = TextStyle(fontSize = 20.sp)
                    )
                    AsyncImage(model = "https:${currentDay.value.icon}",
                        contentDescription = "im2",
                        modifier = Modifier.size(35.dp))
                }
                Text(
                    text = currentDay.value.name,
                    style = TextStyle(fontSize = 35.sp),)
                Text(
                    text = if(currentDay.value.currentTemp.isNotEmpty())
                        currentDay.value.currentTemp.toFloat().toInt().toString()
                    else "${currentDay.value.maxTemp.toFloat().toInt()}°C" +
                            "/${currentDay.value.minTemp.toFloat().toInt()}°C",
                    style = TextStyle(fontSize = 55.sp),)
                Text(
                    text = currentDay.value.condition,
                    style = TextStyle(fontSize = 24.sp),)
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    IconButton(onClick = {
                        onSearchClick.invoke()
                    }) {
                        Icon(painter = painterResource(R.drawable.search),
                            contentDescription = "im3")
                    }
                    Text(text = "${currentDay.value.maxTemp.toFloat().toInt()}°C" +
                            "/${currentDay.value.minTemp.toFloat().toInt()}°C")

                    IconButton(onClick = {
                        onSyncClick.invoke()
                    }) {
                        Icon(painter = painterResource(R.drawable.refresh),
                            contentDescription = "im3")
                    }
                }

            }
            }

    }
}
