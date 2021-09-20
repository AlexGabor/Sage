package com.alexgabor.commonui.catalog.typography

import androidx.compose.runtime.Composable
import com.alexgabor.commonui.catalog.Divider
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.web.dom.H1

@Composable
actual fun Subtitle(text: String) {
    Divider(1)
    H1 {
        Text(text)
    }
}