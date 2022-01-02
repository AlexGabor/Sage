package com.alexgabor.commonui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.alexgabor.common.model.Recipe
import com.alexgabor.commonui.navigation.Destination
import com.alexgabor.commonui.navigation.NavigationController

sealed class Page(override val url: String) : Destination {
    object List : Page("/")
    class Detail(val recipe: Recipe) : Page("/${recipe.toPath()}")
}

@Composable
fun SageNavigation() {
    val controller = remember { NavigationController<Page>() }
    val destinationState = controller.destination.collectAsState()
    when (val destination = destinationState.value) {
        Page.List, null -> RecipeListScreen { recipe -> controller.navigateTo(Page.Detail(recipe)) }
        is Page.Detail -> RecipeDetailScreen(destination.recipe)
    }
}

fun Recipe.toPath(): String = this.name.lowercase().replace(" ", "-")
