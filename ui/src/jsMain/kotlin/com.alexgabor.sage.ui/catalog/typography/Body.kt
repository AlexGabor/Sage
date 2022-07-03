package com.alexgabor.sage.ui.catalog.typography

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Body(
    text: String,
    style: StyleScope.() -> Unit = {},
) {
    Span({
        style {
            fontFamily("Mali", "cursive")
            fontWeight(300)
            fontSize(20.px)
            style(this)
        }
    }) {
        Text(text)
    }
}