package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.common.model.Recipe

@Composable
fun RecipeList(recipes: List<Recipe>, onClick: (recipe: Recipe) -> Unit) {
    recipes.forEach { recipe ->
        RecipePreview(recipe, onClick = { onClick(recipe) })
    }
}