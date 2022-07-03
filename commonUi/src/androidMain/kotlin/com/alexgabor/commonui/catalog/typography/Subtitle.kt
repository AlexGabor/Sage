package com.alexgabor.commonui.catalog.typography

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alexgabor.commonui.catalog.Divider

@Composable
fun Subtitle(text: String) {
    Column(Modifier.fillMaxWidth()) {
        Divider(2)
        BasicText(text = text)
    }
}