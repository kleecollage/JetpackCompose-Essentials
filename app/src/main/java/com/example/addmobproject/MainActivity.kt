package com.example.addmobproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.addmobproject.ui.theme.AddMobProjectTheme
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.initialization.InitializationStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val backgroundScope = CoroutineScope(Dispatchers.IO)
        MobileAds.initialize(this) {}
        /*MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder().setTestDeviceIds(listOf("ABCDEF012345")).build()
        )*/
        setContent {
            AddMobProjectTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BannerView(
                        modifier = Modifier.fillMaxSize(),
                        adId = "ca-app-pub-3940256099942544/9214589741"
                    )
                }
            }
        }
    }
}

@Composable
fun BannerView(modifier: Modifier, adId: String) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.size(24.dp))
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { context ->
                AdView(context).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = adId
                    loadAd(AdRequest.Builder().build())
                    // Logs
                    adListener = object : AdListener() {
                        override fun onAdLoaded() {
                            Log.d("AdMob", "Ad loaded successfully")
                        }
                        override fun onAdFailedToLoad(adError : LoadAdError) {
                            Log.e("AdMob", "Ad failed to load: $adError")
                        }
                    }
                }
            }
        )
    }
}

private fun mobileInit() {

}

















