package com.alexgabor.sage.pages

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.LinkModel
import com.alexgabor.sage.ui.screen.RecipeListScreen
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    RecipeListScreen(recipes = listOf(
        LinkModel("Pancakes", "pancakes"),
        LinkModel("Waffles", "waffles"),
    ))
}