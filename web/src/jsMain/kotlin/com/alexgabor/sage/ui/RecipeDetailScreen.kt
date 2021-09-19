package com.alexgabor.sage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.alexgabor.common.model.Ingredient
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes
import com.alexgabor.commonui.catalog.typography.Subtitle
import com.alexgabor.commonui.catalog.typography.Title
import org.jetbrains.compose.common.foundation.layout.Box
import org.jetbrains.compose.common.internal.castOrCreate
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Modifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
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
            Title("Sage")
            Box(Modifier.castOrCreate().apply { add { height(16.px) } }) { }
            Subtitle(recipe.name)
            Ingredients(recipe.ingredients)
            Steps(recipe.steps)
        }
    }
}

@Composable
fun Ingredients(ingredients: List<Ingredient>) {
    Box(Modifier.castOrCreate().apply {
        add {
            marginTop(16.px)
        }
    }) {
        ingredients.forEach {
            P { Text("${it.quantity} ${it.name}") }
        }
    }
}

@Composable
fun Steps(steps: List<String>) {
    Box(Modifier.castOrCreate().apply {
        add {
            marginTop(16.px)
        }
    }) {
        steps.forEachIndexed { index, step ->
            P {

                Text("${index + 1}. ")
                Text(step)
            }
        }
    }
}

@Composable
fun RecipeDetailScreen(pathname: String, onNotFound: () -> Unit) {
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    val recipe = remember(pathname) { recipes.find { it.name.toPathname() == pathname } }

    if (recipe != null) {
        RecipeDetailScreen(recipe)
    } else {
        onNotFound()
    }
}