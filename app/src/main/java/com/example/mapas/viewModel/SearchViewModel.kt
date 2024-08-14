package com.example.mapas.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapas.models.GoogleGeoResults
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class SearchViewModel: ViewModel() {
    var lat  by mutableDoubleStateOf(0.0)
        private set

    var lng by mutableDoubleStateOf(0.0)
        private  set

    var address by mutableStateOf("")
        private set

    var show by mutableStateOf(false)
        private set

    fun getLocation(search: String) {
        viewModelScope.launch {
            val apiKey = "AIzaSyCT8oXe00Zv7WGoXJAcwyMjY07Z2e02nFY"
            val url = "https://maps.googleapis.com/maps/api/geocode/json?address=$search&key=$apiKey"

            val response = withContext(Dispatchers.IO) {
                URL(url).readText()
            }

            val results = Gson().fromJson(response, GoogleGeoResults::class.java)

            if(results.results.isNotEmpty()) {
                show = true
                lat = results.results[0].geometry.location.lat
                lng = results.results[0].geometry.location.lng
                address = results.results[0].formatted_address
            } else {
                Log.d("Error", "getLocation() is not working!")
            }
        }
    }







}