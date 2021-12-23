package com.alexgabor.sage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.alexgabor.common.model.Ingredient
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes
import com.alexgabor.commonui.catalog.ScreenFrame
import com.alexgabor.commonui.catalog.VerticalSpace
import com.alexgabor.commonui.catalog.typography.Subtitle
import com.alexgabor.commonui.catalog.typography.Title
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

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
fun Ingredients(ingredients: List<Ingredient>) {
    Div({ style { marginTop(16.px) } }) {
        ingredients.forEach {
            P { Text("${it.quantity} ${it.name}") }
        }
    }
}

@Composable
fun Steps(steps: List<String>) {
    Div({ style { marginTop(16.px) } }) {
        steps.forEachIndexed { index, step ->
            P {
                Text("${index + 1}. ")
                Text(step)
            }
        }
    }
}

@Composable
fun RecipeDetailScreen(navigatorState: NavigatorState, pathname: String?) {
    if (pathname == null) {
        navigatorState.navigateTo("/", replace = true)
        return
    }
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    val recipe = recipes.find { it.name.toPathname() == pathname }

    if (recipe != null) {
        RecipeDetailScreen(recipe)
    } else {
        navigatorState.navigateTo("/", replace = true)
    }
}