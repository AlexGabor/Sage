package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Recipe
import com.alexgabor.sage.ui.catalog.typography.Body
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.P

@Composable
fun RecipePreview(recipe: Recipe) {
    A(href = recipe.name.toPathname()) {
        P({
            style {
                marginTop(16.px)
            }
        }) {
            Body(recipe.name)
        }
    }
}

fun String.toPathname(): String {
    return this.lowercase().replace(" ", "-")
}
