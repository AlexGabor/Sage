package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Recipe
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun RecipePreview(recipe: Recipe, onClick: () -> Unit) {
    P({
        onClick { onClick() }
        style {
            marginTop(16.px)
        }
    }) {
        Text(recipe.name)
    }
}
