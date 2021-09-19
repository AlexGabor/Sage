package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px

@Composable
actual fun Divider(size: Int) {
    Box(Modifier.castOrCreate().apply {
        add {
            backgroundColor(Color("#494949"))
            height(size.px)
        }
    }) {
    }
}