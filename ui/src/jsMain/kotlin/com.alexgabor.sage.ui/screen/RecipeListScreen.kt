package com.alexgabor.sage.ui.screen

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.*


@Composable
fun RecipeListScreen(recipes: List<LinkModel>) {
    Screen {
        recipes.forEach { recipe ->
            ItemLink(recipe)
        }
    }
}