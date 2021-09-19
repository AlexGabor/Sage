package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px

@Composable
actual fun VerticalSpace(height: Int) {
    Box(Modifier.castOrCreate().apply { add { height(height.px) } }) { }
}