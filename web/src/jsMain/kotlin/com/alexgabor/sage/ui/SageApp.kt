package com.alexgabor.sage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.alexgabor.commonui.navigation.JsBackDispatcher
import com.alexgabor.commonui.navigation.NavigationRoot
import com.alexgabor.commonui.screen.SageNavigation
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun SageApp() {
    Div({
        style {
            minHeight(100.percent)
            width(100.percent)
            backgroundColor(value = Color("#e8dcd1"))
        }
    }) {
        Div({
            style {
                height(100.percent)
                width(100.percent)
            }
        }) {
            val backDispatcher = remember { JsBackDispatcher() }
            NavigationRoot(backDispatcher) {
                SageNavigation()
            }
        }
    }
}