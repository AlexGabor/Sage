package com.alexgabor.sage.ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.foundation.layout.fillMaxHeight
import org.jetbrains.compose.common.foundation.layout.fillMaxWidth
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.percent

@Composable
fun SageApp() {
    Box(Modifier.castOrCreate().apply {
        add {
            property("min-height", 100.percent)
            property("width", 100.percent)
            property("background-color", "#e8dcd1")
        }
    }) {
        Box(Modifier.fillMaxHeight(1f)
            .fillMaxWidth()) {
            Navigator()
        }
    }
}