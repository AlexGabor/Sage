package com.alexgabor.sage.ui.catalog.typography

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.Divider
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.fontStyle
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun Subtitle(text: String) {
    Divider(1)
    H1({
        style {
            fontFamily("Mali", "cursive")
            fontWeight(600)
            fontStyle("italic")
        }
    }) {
        Text(text)
    }
}