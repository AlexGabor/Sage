package com.alexgabor.sage.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alexgabor.sage.ui.catalog.AppTitle
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun SageApp() {
    ProvideWindowInsets {
        Box(Modifier
            .fillMaxSize()
            .background(Color(0xffe8dcd1))) {
            Column(Modifier
                .statusBarsPadding()
                .padding(16.dp)) {
                AppTitle()
            }
        }
    }
}