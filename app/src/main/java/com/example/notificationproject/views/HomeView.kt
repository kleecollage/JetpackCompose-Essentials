package com.example.notificationproject.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notificationproject.NotificationService
import com.example.notificationproject.NotificationWorker
import com.example.notificationproject.components.MenuLateral
import com.example.notificationproject.components.TopBar

@Composable
fun HomeView(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    MenuLateral(navController, drawerState) {
        ContentHomeView(drawerState)
    }
}

@Composable
fun ContentHomeView(drawerState: DrawerState) {
    Scaffold(
        topBar = {
            TopBar(drawerState = drawerState, title = "Principal")
        }
    ) { pad ->
        NotificationView(pad)
    }
}

@Composable
fun NotificationView(paddingValues: PaddingValues) {
    val context = LocalContext.current
    val notificationService = NotificationService(context)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
    ) {
        Text(text = "Notifications")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { notificationService.showBasicNotification() }) {
            Text(text = "Basic notification")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { notificationService.showLargeNotification() }) {
            Text(text = "Large notification")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { notificationService.showInboxNotification() }) {
            Text(text = "Inbox notification")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { notificationService.showImageNotification() }) {
            Text(text = "Image notification")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { NotificationWorker.releaseNotification(context) }) {
            Text(text = "Background notification")
        }
    }
}
















