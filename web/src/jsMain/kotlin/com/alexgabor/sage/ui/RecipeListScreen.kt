package com.alexgabor.sage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes
import org.jetbrains.compose.common.foundation.clickable
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Modifier
import com.alexgabor.sage.ui.catalog.AppTitle
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P

@Composable
fun RecipeListScreen(onClick: (recipe: Recipe) -> Unit) {
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    Box(Modifier.castOrCreate().apply {
        add {
            property("max-width", 680.px)
            property("margin", "0 auto")
        }
    }) {
        Box(Modifier.castOrCreate().apply {
            add {
                marginLeft(16.px)
                property("margin-right", 16.px)
            }
        }) {
            Box(Modifier.castOrCreate().apply { add { height(16.px) } }) { }
            AppTitle()
            RecipeList(recipes, onClick)
        }
    }
}

@Composable
fun RecipeList(recipes: List<Recipe>, onClick: (recipe: Recipe) -> Unit) {
    recipes.forEach { recipe ->
        RecipePreview(recipe, onClick = { onClick(recipe) })
    }
}

@Composable
fun RecipePreview(recipe: Recipe, onClick: () -> Unit) {
    P({
        style {
            marginTop(16.px)
        }
    }) {
        Text(recipe.name,
            modifier = Modifier.clickable(onClick))
    }
}
