package com.alexgabor.common.model

data class Recipe(
    val name: String,
    val ingredients: List<Ingredient>,
    val steps: List<String>
)
