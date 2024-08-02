package com.example.corrutinasapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.corrutinasapp.ui.theme.CorrutinasAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ItemsViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            CorrutinasAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ItemsView(viewModel)
                }
            }
        }
    }
}

@Composable
fun Content(viewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        BotonColor()
        if (viewModel.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(text = viewModel.resultState)
        }
        Button(onClick = { viewModel.fetchData() }) {
            Text(text = "Llamar API")
        }
    }
}

@Composable
fun BotonColor() {
    var color by remember { mutableStateOf(false) }

    Button(onClick = { color = !color }, colors = ButtonDefaults.buttonColors(
        containerColor = if(color) Color.Blue else Color.Red
    )) {
        Text(text = "Cambiar color")
    }
}

@Composable
fun ItemsView(viewModel: ItemsViewModel) {
    val itemsList = viewModel.itemList
    val lista by viewModel.lista.collectAsState()

    // carga de datos directamente en el Activity
    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }
    
    Column {
        if (viewModel.isLoading) CircularProgressIndicator()
        else {
            LazyColumn {
                items(lista) { item ->
                    Text(text = "${item.id} - ${item.name}")
                }
            }
        }
    }
}
        
















