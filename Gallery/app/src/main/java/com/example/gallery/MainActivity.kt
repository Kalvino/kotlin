package com.example.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gallery.ui.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSizeClass = calculateWindowSizeClass(this)
                    GalleryApp(windowSizeClass)
                }
            }
        }
    }
}

@Composable
fun GalleryApp(windowSizeClass: WindowSizeClass) {
    var currentArt by remember { mutableStateOf(1) }

    fun onNextHandler() {
        if (currentArt == 4) {
            currentArt = 1
        } else (
            currentArt++
        )
    }

    fun onPreviousHandler() {
        if (currentArt == 1) {
            currentArt = 4
        } else {
            currentArt--
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
    ) {
        when (currentArt) {
            1 -> {
                artwork(
                    image = R.drawable.lemon_drink,
                    title = R.string.first,
                    contentDescriptionId = R.string.red_rose,
                    artist = R.string.first_artist,
                    year = R.string.first_year
                )
            }
            2 -> {
                artwork(
                    image = R.drawable.lemon_drink,
                    title = R.string.second,
                    contentDescriptionId = R.string.green_rose,
                    artist = R.string.second_artist,
                    year = R.string.second_year
                )
            }
            3 -> {
                artwork(
                    image = R.drawable.lemon_drink,
                    title = R.string.third,
                    contentDescriptionId = R.string.blue_rose,
                    artist = R.string.third_artist,
                    year = R.string.third_year
                )
            }
            4 -> {
                artwork(
                    image = R.drawable.lemon_drink,
                    title = R.string.fourth,
                    contentDescriptionId = R.string.white_rose,
                    artist = R.string.fourth_artist,
                    year = R.string.fourth_year
                )
            }
        }
        Row (
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            val buttonWidth = Modifier.width(112.dp)
            Button(
                onClick = { onNextHandler() },
                modifier = buttonWidth
            ) {
                Text(text = "previous")
            }
            Button(
                onClick = { onPreviousHandler() },
                modifier = buttonWidth
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun artwork(
    image: Int,
    title: Int,
    artist: Int,
    year: Int,
    contentDescriptionId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(12.dp)
    ) {
        Spacer(modifier = Modifier.height(72.dp))

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shadowElevation = 16.dp
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(contentDescriptionId),
                modifier = Modifier.height(400.dp)
            )
        }
        Spacer(modifier = Modifier.height(76.dp))
        Column(
            modifier = Modifier
                .background(Color(0xFFECEBF4))
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = title),
                fontSize = 20.sp
            )
            Row {
                Text(
                    text = stringResource(id = artist),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = stringResource(id = year)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    GalleryTheme {
//        GalleryApp()
//    }
//}