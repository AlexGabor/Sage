package com.alexgabor.common.usecase

import com.alexgabor.common.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

val Recipes: List<Recipe> = (1..10).map {
    Recipe("Recipe $it")
}

class GetRecipes {

    private val _recipes = MutableStateFlow(Recipes)
    val recipes: StateFlow<List<Recipe>> = _recipes
}