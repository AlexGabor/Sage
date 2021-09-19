package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.px

@Composable
actual fun ScreenFrame(content: @Composable () -> Unit) {
    Box(Modifier.castOrCreate().apply {
        add {
            property("max-width", 680.px)
            property("margin", "0 auto")
        }
    }) {
        Box(Modifier.castOrCreate().apply {
            add {
                marginLeft(16.px)
                property("margin-right", 16.px)
            }
        }) {
            content()
        }
    }
}