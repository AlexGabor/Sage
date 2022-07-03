package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.common.model.Ingredient
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Ingredients(ingredients: List<Ingredient>) {
    Div({ style { marginTop(16.px) } }) {
        ingredients.forEach {
            P { Text("${it.quantity} ${it.name}") }
        }
    }
}

@Composable
fun Steps(steps: List<String>) {
    Div({ style { marginTop(16.px) } }) {
        steps.forEachIndexed { index, step ->
            P {
                Text("${index + 1}. ")
                Text(step)
            }
        }
    }
}
