package com.example.wheatherappcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.wheatherappcompose.ui.theme.BlueLow

const val API_KEY = "13e8cfeba74240938e6101745250704"
@Composable
@Preview
fun MainScreen() {
    Image(
        painter = painterResource(R.drawable.weather),
        contentDescription = "",
        Modifier.fillMaxSize().alpha(0.8f),
        contentScale = ContentScale.Crop

    )

    Column(modifier = Modifier.fillMaxSize().padding(top = 25.dp),
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
            Column(Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {

            }
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

        }
    }
}
