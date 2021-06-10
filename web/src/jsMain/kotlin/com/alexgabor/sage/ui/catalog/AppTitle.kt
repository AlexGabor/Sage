package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.foundation.layout.fillMaxWidth
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun AppTitle() {
    Column(Modifier.fillMaxWidth()) {
        Box(Modifier.castOrCreate().apply {
            add {
                backgroundColor(Color.Named("#494949"))
                height(2.px)
            }
        }) {
        }
        H1 {
            Text("Sage")
        }
    }
}