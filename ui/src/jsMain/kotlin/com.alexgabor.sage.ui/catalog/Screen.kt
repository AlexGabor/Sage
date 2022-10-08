package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.typography.Title

@Composable
fun Screen(
    title: String = "Sage",
    content: @Composable () -> Unit,
) {
    ScreenFrame {
        VerticalSpace(16)
        Title(title)
        VerticalSpace(16)
        content()
    }
}