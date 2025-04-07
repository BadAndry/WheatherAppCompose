package com.example.wheatherappcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wheatherappcompose.ui.theme.BlueLow


@Composable
@Preview
fun MainScreen() {
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
                        text = "12/12/2024 13: 50",
                        style = TextStyle(fontSize = 20.sp)
                    )
                    AsyncImage(model = "https://cdn.weatherapi.com/weather/64x64/day/122.png",
                        contentDescription = "im2",
                        modifier = Modifier.size(35.dp))
                }
                Text(
                    text = "Moscow",
                    style = TextStyle(fontSize = 35.sp),)
                Text(
                    text = "-1°C",
                    style = TextStyle(fontSize = 55.sp),)
                Text(
                    text = "Облачно",
                    style = TextStyle(fontSize = 24.sp),)
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    IconButton(onClick = {

                    }) {
                        Icon(painter = painterResource(R.drawable.search),
                            contentDescription = "im3")
                    }
                    Text(text = "-12°С/-2")

                    IconButton(onClick = {

                    }) {
                        Icon(painter = painterResource(R.drawable.refresh),
                            contentDescription = "im3")
                    }
                }

            }
            }

    }
}
