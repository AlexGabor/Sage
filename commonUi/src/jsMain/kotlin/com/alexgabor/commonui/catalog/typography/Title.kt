package com.alexgabor.commonui.catalog.typography

import androidx.compose.runtime.Composable
import com.alexgabor.commonui.catalog.Divider
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.foundation.layout.fillMaxWidth
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun Title(text: String) {
    Column(Modifier.fillMaxWidth()) {
        Divider(2)
        H1 {
            Text(text)
        }
    }
}