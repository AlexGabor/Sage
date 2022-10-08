package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun Root(content: @Composable () -> Unit) {
    Div({
        style {
            minHeight(100.percent)
            width(100.percent)
            color(Color("#31334a"))
        }
    }) {
        content()
    }
}
