package com.alexgabor.sage

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.Root
import com.varabyte.kobweb.core.App

@App
@Composable
fun SageApp(content: @Composable () -> Unit) {
    Root {
        content()
    }
}
