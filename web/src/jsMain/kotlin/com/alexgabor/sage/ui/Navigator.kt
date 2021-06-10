package com.alexgabor.sage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.browser.window
import com.alexgabor.common.model.Recipe as RecipeModel

class NavigatorState {
    private val _screen: MutableState<Screen> = mutableStateOf(Screen.List)
    val screen: State<Screen> = _screen

    init {
        evaluateLocation(window.location.pathname)
        setOnBackListener()
    }

    fun navigateTo(screen: Screen) {
        window.history.pushState(screen, screen.title, url = screen.url)
        this._screen.value = screen
    }

    fun goBack() {
        window.history.back()
    }

    fun redirectToRoot() {
        window.history.replaceState(Screen.List, Screen.List.title, Screen.List.url)
        _screen.value = Screen.List
    }

    private fun evaluateLocation(pathname: String) {
        val segments = pathname.split("/").filter { it.isNotEmpty() }
        if (pathname.isNotEmpty() && segments.size == 1) {
            _screen.value = Screen.RecipeLink(segments[0])
        } else {
            _screen.value = Screen.List
        }
    }

    private fun setOnBackListener() {
        window.onpopstate = {
            evaluateLocation(window.location.pathname)
        }
    }
}

@Composable
fun rememberNavigatorState(): NavigatorState = remember { NavigatorState() }

@Composable
fun Navigator() {
    val navigatorState = rememberNavigatorState()

    when (val screen = navigatorState.screen.value) {
        Screen.List -> RecipeListScreen(onClick = { recipe ->
            navigatorState.navigateTo(Screen.Recipe(recipe))
        })
        is Screen.Recipe -> {
            RecipeDetailScreen(screen.recipe)
        }
        is Screen.RecipeLink -> {
            RecipeDetailScreen(screen.pathname) {
                navigatorState.redirectToRoot()
            }
        }
    }
}

fun String.toPathname(): String {
    return this.lowercase().replace(" ", "-")
}

sealed class Screen(val title: String, val url: String) {
    object List : Screen("Recipes", "/")
    class Recipe(val recipe: RecipeModel) : Screen(recipe.name, recipe.name.toPathname())
    class RecipeLink(val pathname: String) : Screen("", pathname)
}

