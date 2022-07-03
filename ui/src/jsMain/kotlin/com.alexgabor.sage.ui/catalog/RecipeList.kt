package com.alexgabor.sage.ui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Recipe

@Composable
fun RecipeList(recipes: List<Recipe>) {
    recipes.forEach { recipe ->
        RecipePreview(recipe)
    }
}