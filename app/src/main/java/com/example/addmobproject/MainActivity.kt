package com.example.addmobproject

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.addmobproject.ui.theme.AddMobProjectTheme
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoadCallback
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.initialization.InitializationStatus
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* for physical devices
        MobileAds.initialize(this) {}
            MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder().setTestDeviceIds(listOf("ABCDEF012345")).build()
        )
        */
        setContent {
            AddMobProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    /*BannerView(
                        modifier = Modifier.fillMaxSize(),
                        adId = "ca-app-pub-3940256099942544/9214589741"
                    )*/
                    InterstitialBanner()
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

@Composable
fun InterstitialBanner() {
    val activity = LocalContext.current as Activity
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showInterstitial(activity) }) {
            Text(text = "Mostrar Anuncio")
        }
    }
}

private fun showInterstitial(activity: Activity) {
    loadInterstitialAd(activity) { interstitialAd ->
        if (interstitialAd != null) {
            interstitialAd.show(activity)
        } else {
            Log.d("Error", "Fallo el anuncio")
        }
    }
}

private fun loadInterstitialAd(activity: Activity, callback: (InterstitialAd) -> Unit) {
    val adRequest = AdRequest.Builder().build()

    InterstitialAd.load(
        activity,
        "ca-app-pub-3940256099942544/1033173712",
        adRequest,
        object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(error: LoadAdError) {
                super.onAdFailedToLoad(error)
                Log.d("Error", error.message)
            }

            override fun onAdLoaded(interstitialAD: InterstitialAd) {
                super.onAdLoaded(interstitialAD)
                callback(interstitialAD)
            }
        }
    )
}










