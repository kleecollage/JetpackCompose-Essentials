package com.example.mapas.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mapas.models.LocationModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun MapsView() {
    val markers = listOf(
        LocationModel(coordinates = LatLng(40.758896, -73.985130), name = "Times Square"),
        LocationModel(coordinates = LatLng(40.784444, -73.965517), name = "Central Park"),
        LocationModel(coordinates = LatLng(40.748440, -73.985747), name = "Empire State Building"),
        LocationModel(coordinates = LatLng(40.689249, -74.044500), name = "Statue of Liberty"),
        LocationModel(coordinates = LatLng(40.705789, -73.996411), name = "Brooklyn Bridge"),
        LocationModel(coordinates = LatLng(40.746213, -74.003902), name = "High Line"),
        LocationModel(coordinates = LatLng(40.779411, -73.963877), name = "Metropolitan Museum of Art"),
        LocationModel(coordinates = LatLng(40.583060, -73.975941), name = "Rockefeller Center"),
        LocationModel(coordinates = LatLng(40.827222, -73.926855), name = "Yankee Stadium"),
        LocationModel(coordinates = LatLng(40.712834, -74.006024), name = "One World Trade Center"),
    )
    // val newYork = LatLng(40.758896, -73.985130)
    // val markerState = rememberMarkerState( position = newYork )
    val cameraPosition = CameraPosition.fromLatLngZoom(markers.first().coordinates, 10f)
    val cameraState = rememberCameraPositionState { position = cameraPosition }
    var mapLoading by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraState,
            onMapLoaded = {
                mapLoading = false
            }
        ) {
            markers.forEach { marker ->
                Marker(
                    state = rememberMarkerState(position = marker.coordinates),
                    title = marker.name
                )
            }
        }

        if(mapLoading) {
            AnimatedVisibility(
                visible = mapLoading,
                modifier = Modifier.matchParentSize(),
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.wrapContentSize()
                )
            }
        }
    }
}























