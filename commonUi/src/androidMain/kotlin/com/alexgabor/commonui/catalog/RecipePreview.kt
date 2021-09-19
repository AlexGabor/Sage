package com.alexgabor.commonui.catalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexgabor.common.model.Recipe

@Composable
actual fun RecipePreview(recipe: Recipe, onClick: () -> Unit) {
    BasicText(recipe.name,
        modifier = Modifier.clickable(onClick = onClick).padding(16.dp))
}