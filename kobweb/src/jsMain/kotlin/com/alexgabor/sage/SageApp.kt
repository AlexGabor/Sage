package com.alexgabor.sage

import androidx.compose.runtime.*
import com.alexgabor.sage.ui.screen.RecipeListScreen
import com.varabyte.kobweb.core.App
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@App
@Composable
fun SageApp(content: @Composable () -> Unit) {
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
