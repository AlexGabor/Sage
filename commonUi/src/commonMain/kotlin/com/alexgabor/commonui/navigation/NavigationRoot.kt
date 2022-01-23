package com.alexgabor.commonui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavigationRoot(backDispatcher: BackDispatcher? = null, content: @Composable () -> Unit) {
    val backDispatcherScope = rememberCoroutineScope()
    CompositionLocalProvider(
        LocalUrl provides NativeUrlProvider.getRoot(),
        LocalBackHandler provides backDispatcher?.createBackHandler(backDispatcherScope),
        content = content
    )
}

private fun BackDispatcher.createBackHandler(backDispatcherScope: CoroutineScope): PopStateHandler {
    return PopStateHandler(backDispatcherScope, this)
}