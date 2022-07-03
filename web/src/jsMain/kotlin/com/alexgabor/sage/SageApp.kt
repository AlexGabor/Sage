package com.alexgabor.sage

import androidx.compose.runtime.Composable
import com.alexgabor.sage.navigation.Navigator
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun SageApp() {
    Div({
        style {
            minHeight(100.percent)
            width(100.percent)
            color(Color("#31334a"))
        }
    }) {
        Navigator()
    }
}