package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.common.model.Recipe
import org.jetbrains.compose.common.foundation.clickable
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

@Composable
actual fun RecipePreview(recipe: Recipe, onClick: () -> Unit) {
    P({
        style {
            marginTop(16.px)
        }
    }) {
        Text(recipe.name,
            modifier = Modifier.clickable(onClick))
    }
}
