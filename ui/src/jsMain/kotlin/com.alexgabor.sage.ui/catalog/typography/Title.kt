package com.alexgabor.sage.ui.catalog.typography

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.Divider
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun Title(text: String) {
    Div({
        style {
            width(100.percent)
        }
    }) {
        Divider(2)
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
}