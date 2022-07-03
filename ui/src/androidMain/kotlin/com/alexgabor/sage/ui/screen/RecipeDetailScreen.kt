package com.alexgabor.sage.ui.screen

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Recipe
import com.alexgabor.sage.ui.catalog.Ingredients
import com.alexgabor.sage.ui.catalog.ScreenFrame
import com.alexgabor.sage.ui.catalog.Steps
import com.alexgabor.sage.ui.catalog.VerticalSpace
import com.alexgabor.sage.ui.catalog.typography.Subtitle
import com.alexgabor.sage.ui.catalog.typography.Title


@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    ScreenFrame {
        VerticalSpace(16)
        Title("Sage")
        VerticalSpace(16)
        Subtitle(recipe.name)
        Ingredients(recipe.ingredients)
        Steps(recipe.steps)
    }
}