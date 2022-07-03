package com.alexgabor.sage.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.alexgabor.sage.common.model.Recipe
import com.alexgabor.sage.common.usecase.GetRecipes
import com.alexgabor.sage.ui.catalog.RecipeList
import com.alexgabor.sage.ui.catalog.ScreenFrame
import com.alexgabor.sage.ui.catalog.VerticalSpace
import com.alexgabor.sage.ui.catalog.typography.Title

@Composable
fun RecipeListScreen(onClick: (recipe: Recipe) -> Unit) {
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    ScreenFrame {
        VerticalSpace(16)
        Title("Sage")
        RecipeList(recipes, onClick)
    }
}