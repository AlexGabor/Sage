package com.alexgabor.commonui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes
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

@Composable
fun RecipeDetailScreen(pathname: String?, onNotFound: () -> Unit) {
    if (pathname == null) {
        onNotFound.invoke()
        return
    }
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    val recipe = recipes.find { it.toPath() == pathname }

    if (recipe != null) {
        RecipeDetailScreen(recipe)
    } else {
        onNotFound()
    }
}