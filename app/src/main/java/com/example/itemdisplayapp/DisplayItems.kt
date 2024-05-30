package com.example.itemdisplayapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.itemdisplayapp.ui.theme.ItemDisplayAppTheme

class DisplayItems : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItemDisplayAppTheme {
                Column {
                    TopAppBar(
                        title = {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "XP COMPUTERS",
                                    style = MaterialTheme.typography.headlineMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.white)
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = colorResource(id = R.color.heading),
                        )
                    )
                    DataDisplay(acessorieslist)
                    Spacer(modifier = Modifier.weight(1f))  // Add some spacing before the button
                    NewActivityButton(this@DisplayItems)
                }
            }
        }
    }
}

@Composable
fun DataDisplay(Accessorieslist: List<Accesories>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(Accessorieslist) { accessory ->
            ItemsDisplay(accessory, Modifier.padding(16.dp))
        }
    }
}

@Composable
fun ItemsDisplay(accessory: Accesories, modifier: Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 8.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = accessory.imageRes),
                contentDescription = "Accessories",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = accessory.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = accessory.price,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun NewActivityButton(context: Context) {
    val navigate = Intent(context, DisplayItem::class.java)
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.yellow)),
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 16.dp),
        shape = CircleShape,
        onClick = {
            context.startActivity(navigate)
        }) {
        Text(text = "Full View", textAlign = TextAlign.Center)
    }
}
