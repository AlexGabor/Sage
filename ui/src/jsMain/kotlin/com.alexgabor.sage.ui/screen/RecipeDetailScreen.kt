package com.alexgabor.sage.ui.screen

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Recipe
import com.alexgabor.sage.ui.catalog.Ingredients
import com.alexgabor.sage.ui.catalog.Screen
import com.alexgabor.sage.ui.catalog.Steps
import com.alexgabor.sage.ui.catalog.typography.Subtitle


@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    Screen {
        Subtitle(recipe.name)
        Ingredients(recipe.ingredients)
        Steps(recipe.steps)
    }
}