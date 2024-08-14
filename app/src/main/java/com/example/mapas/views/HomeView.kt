package com.example.mapas.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mapas.viewModel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeVew(navController: NavController, searchVM: SearchViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Search Place")})
        }
    ) { pad ->
        Column(
            modifier = Modifier
                .padding(pad)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var search by remember { mutableStateOf("") }

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                label = { Text(text = "Search")}
            )

            OutlinedButton(onClick = { searchVM.getLocation(search) }) {
                Text(text = "Search")
            }

            if(searchVM.show) {
                Text(text = "Latitude ${searchVM.lat}")
                Text(text = "Longitude ${searchVM.lng}")
                Text(text = "Address ${searchVM.address}")
                OutlinedButton(
                    onClick = {
                        navController.navigate("MapSearchView/${searchVM.lat}/${searchVM.lng}/${searchVM.address}")
                    }) {
                    Text(text = "Send")
                }
            }
        }

    }
}