package com.alexgabor.commonui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.alexgabor.common.model.Recipe
import com.alexgabor.commonui.navigation.*

sealed class Page(override val path: String) : Destination {
    object List : Page("/")
    class Detail(val recipe: Recipe) : Page("/${recipe.toPath()}")
    class DetailLink(val recipeName: String) : Page("/$recipeName")
}

@Composable
fun <T : Destination> registerBackHandler(
    popStateHandler: PopStateHandler,
    controller: NavigationController<T>
) {
    DisposableEffect(popStateHandler, controller) {
        val handler = Handler { if (it == Direction.Back) controller.goBack() != null else controller.goForward() != null }
        popStateHandler.register(handler)
        onDispose {
            popStateHandler.unregister(handler)
        }
    }
}

@Composable
fun SageNavigation() {
    val deepLink = if (LocalUrl.current != "/") Page.DetailLink(LocalUrl.current.drop(1)) else null

    val controller = remember { NavigationController<Page>(deepLink) }
    val backHandler = LocalBackHandler.current
    if (backHandler != null) registerBackHandler(backHandler, controller)

    val destinationState = controller.destination.collectAsState()
    when (val destination = destinationState.value) {
        Page.List, null -> RecipeListScreen { recipe -> controller.navigateTo(Page.Detail(recipe)) }
        is Page.Detail -> RecipeDetailScreen(destination.recipe)
        is Page.DetailLink -> RecipeDetailScreen(destination.recipeName) {
            controller.navigateTo(Page.List)
        }
    }
}

fun Recipe.toPath(): String = this.name.lowercase().replace(" ", "-")
