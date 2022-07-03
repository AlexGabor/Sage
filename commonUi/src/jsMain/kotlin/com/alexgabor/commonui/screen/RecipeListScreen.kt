package com.alexgabor.commonui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes
import com.alexgabor.commonui.catalog.RecipeList
import com.alexgabor.commonui.catalog.ScreenFrame
import com.alexgabor.commonui.catalog.VerticalSpace
import com.alexgabor.commonui.catalog.typography.Title

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