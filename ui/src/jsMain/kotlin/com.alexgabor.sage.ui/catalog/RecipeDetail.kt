package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Ingredient
import com.alexgabor.sage.ui.catalog.typography.Body
import org.jetbrains.compose.web.css.fontStyle
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P

@Composable
fun Ingredients(ingredients: List<Ingredient>) {
    Div({ style { marginTop(16.px) } }) {
        ingredients.forEach {
            P {
                if (it.quantity.trim().isNotEmpty()) {
                    Body("${it.quantity} ~ ", style = {
                        fontWeight(500)
                    })
                }
                Body(it.name)
            }
        }
    }
}

@Composable
fun Steps(steps: List<String>) {
    Div({ style { marginTop(16.px) } }) {
        steps.forEachIndexed { index, step ->
            P {
                Body("${index + 1}. ", style = {
                    fontWeight(500)
                })
                Body(step)
            }
        }
    }
}
