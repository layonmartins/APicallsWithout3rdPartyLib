package com.example.apicallswithout3rdpartylib

import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.apicallswithout3rdpartylib.networking.NetworkChecker
import com.example.apicallswithout3rdpartylib.networking.RemoteApi
import com.example.apicallswithout3rdpartylib.ui.theme.APIcallsWithout3rdPartyLibTheme

class MainActivity : ComponentActivity() {

    private val networkChecker by lazy {
        NetworkChecker(getSystemService(ConnectivityManager::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APIcallsWithout3rdPartyLibTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        RemoteApi().getFact()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    APIcallsWithout3rdPartyLibTheme {
        MainScreen()
    }
}