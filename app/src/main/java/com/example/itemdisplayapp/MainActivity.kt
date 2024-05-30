package com.example.itemdisplayapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.itemdisplayapp.ui.theme.ItemDisplayAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        enableEdgeToEdge()
        setContent {
            ItemDisplayAppTheme {
                MainScreen(this)
            }
        }
    }
}

@Composable
fun MainScreen(context: Context){
    val navigate= Intent(context,DisplayItems::class.java)
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
    Box(
    ) {
        LottieTheme()
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,

        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.xp_computers),
                fontSize = MaterialTheme.typography.displayLarge.fontSize,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white)
            )
            //LottieAnimation(
              //  composition = composition,
                //progress = { progress },
                //modifier = Modifier
                  //  .size(300.dp)
                    //.padding(top = 64.dp, bottom = 64.dp)

            //)
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.we_deals_in_all_kind_of_quality_products_like_accessories_mobiles_laptops_computers_in_cheap_rates),
                color= colorResource(id = R.color.white),
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = FontWeight.Normal
                )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                modifier = Modifier
                    .height(54.dp)
                    .fillMaxWidth(),
                onClick = {
                    //isPlaying = true
                    context.startActivity(navigate)
                },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.yellow)),
                //modifier = Modifier
                  //  .size(100.dp)
                    )
             {
                Text(
                    text = "Check Products",
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.height(74.dp))
        }
    }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ItemDisplayAppTheme {
    }
}