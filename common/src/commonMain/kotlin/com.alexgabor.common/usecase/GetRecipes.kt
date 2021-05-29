package com.alexgabor.common.usecase

import com.alexgabor.common.Recipes
import com.alexgabor.common.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GetRecipes {

    private val _recipes = MutableStateFlow(Recipes)
    val recipes: StateFlow<List<Recipe>> = _recipes
}