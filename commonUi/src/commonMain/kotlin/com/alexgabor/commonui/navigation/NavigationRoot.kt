package com.alexgabor.commonui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun NavigationRoot(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalUrl provides NativeUrlProvider.getRoot(),
        content = content
    )
}
