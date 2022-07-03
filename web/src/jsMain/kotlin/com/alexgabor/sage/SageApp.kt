package com.alexgabor.sage

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import com.alexgabor.sage.navigation.Navigator
import org.jetbrains.compose.web.css.*

@Composable
fun SageApp() {
    Div({
        style {
            minHeight(100.percent)
            width(100.percent)
            backgroundColor(value = Color("#e8dcd1"))
            color(Color("#31334a"))
        }
    }) {
        Div({
            style {
                height(100.percent)
                width(100.percent)
            }
        }) {
            Navigator()
        }
    }
}