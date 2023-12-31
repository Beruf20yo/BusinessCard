package com.sqz.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.sqz.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073042),
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BusinessCardImage()
        BusinessCardText()
    }
}

@Composable
fun BusinessCardText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.Author),
        fontSize = 35.sp,
        modifier = modifier.padding(top = 20.dp)
    )
    Text(
        text = stringResource(R.string.Title),
        modifier = modifier.padding(top = 20.dp),
        fontWeight = FontWeight.Bold,
        color = Color(0xFF3DDB83)
    )
    Row(
        modifier = modifier.padding(top = 70.dp)
    ){
        Text(
            text = stringResource(R.string.Github),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = stringResource(R.string.GithubAccount),
            modifier = modifier.padding(start = 5.dp),
            fontSize = 18.sp
        )
    }
}

@Composable
fun BusinessCardImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = modifier.size(width = 150.dp, height = 150.dp)
    )
}

//To check design preview in Android Studio
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF073042),
        ) {
            BusinessCard()
        }
    }
}