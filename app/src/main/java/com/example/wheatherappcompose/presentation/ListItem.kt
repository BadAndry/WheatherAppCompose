package com.example.wheatherappcompose.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wheatherappcompose.data.ItemWeatherModel
import com.example.wheatherappcompose.ui.theme.BlueLow

@Composable
fun MainList(list: List<ItemWeatherModel>, currentDay: MutableState<ItemWeatherModel>){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(
            list
        ) { _, item ->
            ListItem(item, currentDay)
        }

    }
}


@Composable
fun ListItem(items: ItemWeatherModel, currentDay: MutableState<ItemWeatherModel>){
    Card(modifier = Modifier.fillMaxWidth().clickable {
        //Берется при нажатии на какой то item значения currentDay, если нет значения то возвращаем пустой кликейбл
        if(items.hours.isEmpty()) return@clickable
        currentDay.value = items
    },
        colors = CardDefaults.cardColors(
            containerColor = BlueLow
        ),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                    text = items.time,
                    color = Color.White,
                    style = TextStyle(fontSize = 15.sp),

                    )
                Text(
                    modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                    text = items.condition,
                    color = Color.White,
                    style = TextStyle(fontSize = 15.sp)
                )
            }
            Text(
                modifier = Modifier.padding(top = 8.dp, start = 8.dp),
                color = Color.White,
                text = items.currentTemp.ifEmpty {"${items.maxTemp.toFloat().toInt()}°C" +
                        "/${items.minTemp.toFloat().toInt()}°C"},
                style = TextStyle(fontSize = 25.sp)
            )

            AsyncImage(
                model = "https:${items.icon}",
                contentDescription = "im5",
                modifier = Modifier.size(35.dp)
            )
        }

    }
}