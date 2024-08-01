package com.example.loteria

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.loteria.ui.theme.LoteriaTheme
import com.example.loteria.view.Contador
import com.example.loteria.view.LoteriaView
import com.example.loteria.viewModels.ContadorViewModel
import com.example.loteria.viewModels.LoteriaViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // val viewModel: ContadorViewModel by viewModels()
        val viewModel: LoteriaViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            LoteriaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    // Contador(viewModel = viewModel)
                    LoteriaView(viewModel = viewModel)
                }
            }
        }
    }
}