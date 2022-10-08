package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.typography.Body
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.P

data class LinkModel(
    val name: String,
    val path: String,
)

@Composable
fun ItemLink(recipe: LinkModel) {
    A(href = recipe.path) {
        P({
            style {
                marginTop(16.px)
            }
        }) {
            Body(recipe.name)
        }
    }
}