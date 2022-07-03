package com.alexgabor.commonui.catalog.typography

import androidx.compose.runtime.Composable
import com.alexgabor.commonui.catalog.Divider
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.width
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
        H1 {
            Text(text)
        }
    }
}