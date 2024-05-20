package com.example.itemdisplayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itemdisplayapp.ui.theme.ItemDisplayAppTheme

class DisplayItem : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItemDisplayAppTheme {
             Display()
            }
        }
    }
}
@Composable
fun Display() {
    var i by remember{ mutableIntStateOf(1) }
    if(i==6){i=1}
    val model= when(i){
        1 -> painterResource(id = R.drawable.apple_iphone_5_smartphone___800x902)
        2-> painterResource(id = R.drawable.samsung_galaxy_s10_ceramic_black_back___1280x854)
        3-> painterResource(id = R.drawable.samsung_galaxy_s10_ceramic_black_front___1280x854)
        4-> painterResource(id = R.drawable.smartphone_iphone_11_pro_max_silver___1280x854)
        else->
            painterResource(id = R.drawable.samsung_galaxy_s10_prism_white_back___1280x854)
    }
        val modelTye= when(model){
            painterResource(id = R.drawable.apple_iphone_5_smartphone___800x902)-> stringResource(id = R.string.iphone_5)
            painterResource(id = R.drawable.samsung_galaxy_s10_ceramic_black_back___1280x854)-> stringResource(id = R.string.galaxy_s10_ceramic_black_back)
            painterResource(id = R.drawable.samsung_galaxy_s10_ceramic_black_front___1280x854)-> stringResource(id = R.string.galaxy_s10_ceramic_black_front)
            painterResource(id = R.drawable.smartphone_iphone_11_pro_max_silver___1280x854)-> stringResource(id = R.string.iphone_11)
            else
                -> stringResource(id = R.string.galaxy_s10_prism_white_back)

        }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.sky_blue)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.xp_computers),
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text_color))
        Spacer(modifier = Modifier.padding(16.dp))
        Image(
            painter = model,
            contentDescription = "phone image",
            modifier = Modifier
                .height(300.dp)
                .width(200.dp))
        Text(
            text = "$modelTye",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text_color),
            modifier = Modifier.padding(24.dp))

        Button(onClick = {i++},
            modifier = Modifier
                .size(100.dp)
                .background(color = colorResource(id = R.color.sky_blue))) {
            Text(
                text = stringResource(R.string.next2),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Display()
}