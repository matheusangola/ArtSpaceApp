package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var artNumber by remember{ mutableStateOf(1) }
    var imageResource = when(artNumber) {
        1 -> R.drawable.image_1
        2 -> R.drawable.image_2
        else -> R.drawable.image_3
    }
    var titleResource = when(artNumber) {
        1 -> R.string.title1
        2 -> R.string.title2
        else -> R.string.title3
    }
    var titleResource2 = when(artNumber) {
        1 -> R.string.author1
        2 -> R.string.author2
        else -> R.string.author3
    }
    Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally){
        Surface(shadowElevation = 16.dp, modifier = Modifier
            .height(450.dp)
            .width(285.dp)
            .padding(0.dp, 20.dp, 0.dp, 20.dp)){
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 20.dp, 0.dp, 20.dp),
                painter = painterResource(imageResource),
                contentDescription = null
            )
        }

        Column(modifier = Modifier
            .padding(4.dp)){
            Text(
                text = stringResource(titleResource),
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(4.dp)
            )
            Text(
                text = stringResource(titleResource2),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
        Row(){
            Button(onClick = {
                             if (artNumber != 1) {
                                 artNumber--
                             } else {
                                 artNumber = 3
                             }
                             }, modifier = Modifier
                .padding(0.dp, 0.dp, 14.dp, 0.dp)) {
                Text("Previous")
            }
            Button(onClick = {
                if (artNumber != 3) {
                artNumber++
            } else {
                artNumber = 1
            } }, modifier = Modifier
                .padding(14.dp, 0.dp, 0.dp, 0.dp,)) {
                Text("     Next     ")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}