package com.alexgabor.sage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.web.css.Color
import androidx.compose.web.css.backgroundColor
import androidx.compose.web.css.height
import androidx.compose.web.css.marginLeft
import androidx.compose.web.css.marginTop
import androidx.compose.web.css.px
import androidx.compose.web.css.value
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.H1
import androidx.compose.web.elements.P
import androidx.compose.web.elements.Text
import com.alexgabor.common.model.Ingredient
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes
import com.alexgabor.sage.ui.catalog.AppTitle

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    Div(style = {
        property("max-width", value(680.px))
        property("margin", value("0 auto"))
    }) {
        Div(style = {
            marginLeft(16.px)
            property("margin-right", value(16.px))
        }) {
            Div(style = {
                height(16.px)
            }) { }
            AppTitle()
            Div(style = {
                height(16.px)
            }) { }
            RecipeTitle(recipe.name)
            Ingredients(recipe.ingredients)
            Steps(recipe.steps)
        }
    }
}

@Composable
fun Ingredients(ingredients: List<Ingredient>) {
    Div(style = {
        marginTop(16.px)
    }) {
        ingredients.forEach {
            P { Text("${it.quantity} ${it.name}") }
        }
    }
}

@Composable
fun Steps(steps: List<String>) {
    Div(style = {
        marginTop(16.px)
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

@Composable
fun RecipeTitle(text: String) {
    Div(style = {
        backgroundColor(Color.Named("#494949"))
        height(1.px)
    }) {
    }
    H1 {
        Text(text)
    }
}