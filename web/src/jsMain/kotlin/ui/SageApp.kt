package ui

import androidx.compose.runtime.Composable
import org.jetbrains.compose.common.core.graphics.Color
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.foundation.layout.fillMaxHeight
import org.jetbrains.compose.common.foundation.layout.fillMaxWidth
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.common.ui.background

@Composable
fun SageApp() {
    Box(Modifier.fillMaxHeight(1f)
        .fillMaxWidth()
        .background(Color(0xe8, 0xdc, 0xd1))) {
        Navigator()
    }
}