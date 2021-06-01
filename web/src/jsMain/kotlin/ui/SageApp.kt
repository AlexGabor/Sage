package ui

import androidx.compose.runtime.Composable
import androidx.compose.web.css.percent
import androidx.compose.web.css.value
import androidx.compose.web.elements.Div
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.foundation.layout.fillMaxHeight
import org.jetbrains.compose.common.foundation.layout.fillMaxWidth
import org.jetbrains.compose.common.ui.Modifier

@Composable
fun SageApp() {
    Div(style = {
        property("min-height", value(100.percent))
        property("width", value(100.percent))
        property("background-color", value("#e8dcd1"))
    }) {
        Box(Modifier.fillMaxHeight(1f)
            .fillMaxWidth()) {
            Navigator()
        }
    }
}