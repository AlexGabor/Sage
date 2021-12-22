package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.common.model.Recipe
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun RecipePreview(recipe: Recipe, onClick: () -> Unit) {
    P({
        onClick { onClick() }
        style {
            marginTop(16.px)
        }
    }) {
        Text(recipe.name)
    }
}
