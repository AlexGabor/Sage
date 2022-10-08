package com.alexgabor.sage.pages

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Ingredient
import com.alexgabor.sage.common.model.Recipe
import com.alexgabor.sage.ui.screen.RecipeDetailScreen
import com.varabyte.kobweb.core.Page

@Page("pancakes")
@Composable
fun Pancakes() {
    RecipeDetailScreen(
        recipe = Recipe(
            name = "Pancakes",
            ingredients = listOf(
                Ingredient("1 cup", "milk"),
                Ingredient("2 spoons", "vinegar"),
                Ingredient("1 cup", "flour"),
                Ingredient("2 spoons", "sugar"),
                Ingredient("1 teaspoon", "baking soda"),
                Ingredient("1/2 teaspoon", "bicarbonate of soda"),
                Ingredient("1/2 teaspoon", "salt"),
                Ingredient("1", "egg"),
                Ingredient("2 spoons", "melted butter"),
            ),
            steps = listOf(
                "Mix everything",
            )
        ),
    )
}