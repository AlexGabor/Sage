package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Composable
fun Divider(size: Int) {
    Div({
        style {
            backgroundColor(Color("#31334a"))
            height(size.px)
        }
    }) {
    }
}