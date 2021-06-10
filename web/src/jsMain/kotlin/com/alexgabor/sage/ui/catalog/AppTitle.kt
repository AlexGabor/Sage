package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import androidx.compose.web.css.Color
import androidx.compose.web.css.backgroundColor
import androidx.compose.web.css.height
import androidx.compose.web.css.px
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.H1
import androidx.compose.web.elements.Text
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.foundation.layout.fillMaxWidth
import org.jetbrains.compose.common.ui.Modifier

@Composable
fun AppTitle() {
    Column(Modifier.fillMaxWidth()) {
        Div(style = {
            backgroundColor(Color.Named("#494949"))
            height(2.px)
        }) {
        }
        H1 {
            Text("Sage")
        }
    }
}