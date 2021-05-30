package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.browser.window
import com.alexgabor.common.model.Recipe as RecipeModel

@Composable
fun Navigator() {
    val screen = remember { mutableStateOf<Screen>(Screen.List) }

    LaunchedEffect(Unit) {
        console.log(window.location.pathname)
        val segments = window.location.pathname.split("/").filter { it.isNotEmpty() }
        if (window.location.pathname.isNotEmpty() && segments.size == 1) {
            screen.value = Screen.RecipeLink(segments[0])
        } else {
            window.history.replaceState(window.history.state, "Recipes", "/")
        }
    }

    window.onpopstate = {
        screen.value = Screen.List
        Unit
    }

    when (val s = screen.value) {
        Screen.List -> RecipeListScreen(onClick = { recipe ->
            window.history.pushState(recipe, recipe.name, recipe.name.toPathname())
            screen.value = Screen.Recipe(recipe)
        })
        is Screen.Recipe -> {
            RecipeDetailScreen(s.recipe)
        }
        is Screen.RecipeLink -> {
            RecipeDetailScreen(s.pathname) {
                window.history.replaceState(window.history.state, "Recipes", "/")
                screen.value = Screen.List
            }
        }
    }
}

fun String.toPathname(): String {
    return this.toLowerCase().replace(" ", "-")
}

sealed class Screen {
    object List : Screen()
    class Recipe(val recipe: RecipeModel) : Screen()
    class RecipeLink(val pathname: String) : Screen()
}

