package com.alexgabor.commonui.catalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexgabor.common.model.Ingredient

@Composable
actual fun Ingredients(ingredients: List<Ingredient>) {
    Box(Modifier.padding(top = 16.dp)) {
        ingredients.forEach {
            BasicText("${it.quantity} ${it.name}")
        }
    }
}

@Composable
fun Steps(steps: List<String>) {
    Box(Modifier.padding(top = 16.dp)) {
        steps.forEachIndexed { index, step ->
            BasicText("${index + 1}. $step")
        }
    }
}
