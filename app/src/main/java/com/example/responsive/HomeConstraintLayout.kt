package com.example.responsive

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun HomeConstraintLayout(windowSizeClass: WindowSizeClass) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (cardRed, cardBlue, cardGreen, cardCyan, cardYellow) = createRefs()
        val startGuideCompact = createGuidelineFromStart(0.2f)
        val startGuideExpand = createGuidelineFromStart(270.dp)

        Box(modifier = Modifier.size(150.dp).background(Color.Red).constrainAs(cardRed){
            top.linkTo(cardBlue.top)
            bottom.linkTo(cardBlue.bottom)
            start.linkTo(cardBlue.end, margin = 30.dp)
        })

        Box(modifier = Modifier.size(250.dp).background(Color.Blue).constrainAs(cardBlue){
//            top.linkTo(cardGreen.bottom, margin = 10.dp)
//            when(windowSizeClass.widthSizeClass) {
//                WindowWidthSizeClass.Compact -> {
//                    start.linkTo(startGuideCompact)
//                }
//                WindowWidthSizeClass.Expanded -> {
//                    start.linkTo(startGuideExpand)
//                }
//            }
            top.linkTo(cardYellow.bottom, margin = 20.dp)
            start.linkTo(cardYellow.start, margin = (-70).dp)
        })

        Box(modifier = Modifier.size(200.dp).background(Color.Green).constrainAs(cardGreen){
            top.linkTo(cardYellow.top)
            start.linkTo(parent.start, margin = 15.dp)
        })

        Box(modifier = Modifier.size(125.dp).background(Color.Cyan).constrainAs(cardCyan){
            top.linkTo(cardYellow.top)
            end.linkTo(parent.end, margin = 15.dp)
        })

        Box(modifier = Modifier.size(175.dp).background(Color.Yellow).constrainAs(cardYellow){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        createHorizontalChain(cardCyan, cardYellow, cardGreen, chainStyle = ChainStyle.Spread)
    }
}

















