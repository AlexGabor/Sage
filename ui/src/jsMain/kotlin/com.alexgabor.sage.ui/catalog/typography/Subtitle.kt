package com.alexgabor.sage.ui.catalog.typography

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.Divider
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun Subtitle(text: String) {
    Divider(1)
    H1 {
        Text(text)
    }
}