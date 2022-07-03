package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun ScreenFrame(content: @Composable () -> Unit) {
    Div({
        style {
            maxWidth(680.px)
            property("margin", "0 auto")
        }
    }) {
        Div({
            style {
                marginLeft(16.px)
                marginRight(16.px)
                paddingBottom(64.px)
            }
        }) {
            content()
        }
    }
}