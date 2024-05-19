package com.example.itemdisplayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.itemdisplayapp.ui.theme.ItemDisplayAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItemDisplayAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    var isPlaying by remember{ mutableStateOf(true) }
    val progress by animateLottieCompositionAsState(
        composition=composition,
        isPlaying = isPlaying)
    LaunchedEffect(key1 = progress) {
        if (progress == 0f) {
           isPlaying = true
        }
        if (progress == 1f) {
            isPlaying = false
        }
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
            fontWeight = FontWeight.Bold)
        LottieAnimation(
            composition = composition,
            progress ={progress}
            )
        Button(onClick = { isPlaying =true }) {
            Modifier.size(24.dp)
            Text(
                text = stringResource(R.string.start)
            )

        }
    }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ItemDisplayAppTheme {
        MainScreen()
    }
}