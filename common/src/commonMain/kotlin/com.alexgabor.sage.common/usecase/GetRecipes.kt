package com.alexgabor.sage.common.usecase

import com.alexgabor.sage.common.Recipes
import com.alexgabor.sage.common.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GetRecipes {

    private val _recipes = MutableStateFlow(Recipes)
    val recipes: StateFlow<List<Recipe>> = _recipes
}