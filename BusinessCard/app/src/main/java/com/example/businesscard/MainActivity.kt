package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffd2e8d4)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 250.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalData()
        Contact()
    }
}

@Composable
private fun PersonalData() {
    Box {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            val image = painterResource(R.drawable.calvin)

            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .size(100.dp)
            )
            Text(
                text = "Calvin Odira",
                fontSize = 35.sp,
                letterSpacing = 2.sp,
            )
            Text(
                text = "Android Developer Extraordinaire",
                color = Color(0xFF006D3B),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}

@Composable
fun Contact() {
    Box(
        modifier = Modifier.padding(20.dp)
    ) {
        Column {

            ComposableContact(
                icon = Icons.Default.Phone,
                contact = "+254728085749",
                iconDescription = "Phone number icon"
            )
            ComposableContact(
                icon = Icons.Default.Share,
                contact = "@aurora.khal",
                iconDescription = "Social media share icon"
            )
            ComposableContact(
                icon = Icons.Default.Email,
                contact = "khal@aurora.org",
                iconDescription = "Email address icon"
            )
        }
    }
}

@Composable
fun ComposableContact(
    icon: ImageVector,
    contact: String,
    iconDescription: String,
) {
    Row(
        modifier = Modifier.padding(bottom = 15.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            modifier = Modifier.size(20.dp),
            tint = Color(0xFF006D3B)
        )
        Text(
            text = contact,
            modifier = Modifier.padding(start = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}