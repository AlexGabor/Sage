package com.alexgabor.sage.ui

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
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.px

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