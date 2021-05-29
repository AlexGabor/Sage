package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.web.elements.P
import androidx.compose.web.elements.Text
import com.alexgabor.common.usecase.GetRecipes
import kotlinx.browser.window
import com.alexgabor.common.model.Recipe as RecipeModel

@Composable
fun Navigator() {
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    val screen = remember { mutableStateOf<Screen>(Screen.List) }
    LaunchedEffect(Unit) {
        console.log(window.location.pathname)
        val segments = window.location.pathname.split("/").filter { it.isNotEmpty() }
        if (window.location.pathname.isNotEmpty() && segments.size == 1) {
            val recipe = recipes.find { it.name.toPathname() == segments[0] }
            if (recipe != null) {
                screen.value = Screen.Recipe(recipe)
            } else {
                window.history.replaceState(window.history.state, "Recipes", "/")
            }
        }
    }
    window.onpopstate = {
        screen.value = Screen.List
        Unit
    }

    when (val s = screen.value) {
        Screen.List -> RecipeList(recipes, onClick = { recipe ->
            window.history.pushState(recipe, recipe.name, recipe.name.toPathname())
            screen.value = Screen.Recipe(recipe)
        })
        is Screen.Recipe -> {
            s.recipe.ingredients.forEach {
                P { Text("${it.quantity} ${it.name}") }
            }
        }
    }
}

private fun String.toPathname(): String {
    return this.toLowerCase().replace(" ", "-")
}

sealed class Screen {
    object List : Screen()
    class Recipe(val recipe: RecipeModel) : Screen()
}

