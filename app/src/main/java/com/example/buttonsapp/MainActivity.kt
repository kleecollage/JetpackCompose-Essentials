package com.example.buttonsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.buttonsapp.components.BotonIcono
import com.example.buttonsapp.components.BotonNormal
import com.example.buttonsapp.components.BotonNormal2
import com.example.buttonsapp.components.BotonOutline
import com.example.buttonsapp.components.BotonSwitch
import com.example.buttonsapp.components.BotonTexto
import com.example.buttonsapp.components.DarkMode
import com.example.buttonsapp.components.FloatingAction
import com.example.buttonsapp.components.Space
import com.example.buttonsapp.ui.theme.ButtonsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val darkMode = remember { mutableStateOf(false) }
            ButtonsAppTheme(darkTheme = darkMode.value) {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Content(modifier = Modifier.padding(innerPadding), darkMode = darkMode)
                }
            }
        }
    }
}
@Composable
fun Content( modifier: Modifier = Modifier, darkMode: MutableState<Boolean>) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BotonNormal()
        Space()
        BotonNormal2()
        Space()
        BotonTexto()
        Space()
        BotonOutline()
        Space()
        BotonIcono()
        Space()
        BotonSwitch()
        Space()
        DarkMode(darkMode = darkMode)
        Space()
        FloatingAction()
    }
}
