package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Recipe
import com.alexgabor.sage.ui.catalog.typography.Body
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

@Composable
fun RecipePreview(recipe: Recipe, onClick: () -> Unit) {
    P({
        onClick { onClick() }
        style {
            marginTop(16.px)
        }
    }) {
        Body(recipe.name)
    }
}
