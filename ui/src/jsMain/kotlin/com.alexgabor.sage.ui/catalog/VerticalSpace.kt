package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Composable
fun VerticalSpace(height: Int) {
    Div({ style { height(height.px) } }) {}
}