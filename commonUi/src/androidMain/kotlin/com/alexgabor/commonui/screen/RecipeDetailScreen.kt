package com.alexgabor.commonui.screen

import androidx.compose.runtime.Composable
import com.alexgabor.common.model.Recipe
import com.alexgabor.commonui.catalog.Ingredients
import com.alexgabor.commonui.catalog.ScreenFrame
import com.alexgabor.commonui.catalog.Steps
import com.alexgabor.commonui.catalog.VerticalSpace
import com.alexgabor.commonui.catalog.typography.Subtitle
import com.alexgabor.commonui.catalog.typography.Title


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