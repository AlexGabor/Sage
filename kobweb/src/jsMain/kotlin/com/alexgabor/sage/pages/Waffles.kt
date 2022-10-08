package com.alexgabor.sage.pages

import androidx.compose.runtime.Composable
import com.alexgabor.sage.common.model.Ingredient
import com.alexgabor.sage.common.model.Recipe
import com.alexgabor.sage.ui.screen.RecipeDetailScreen
import com.varabyte.kobweb.core.Page

@Page("waffles")
@Composable
fun Waffles() {
    RecipeDetailScreen(
        recipe = Recipe("Waffles",
            ingredients = listOf(
                Ingredient("2", "eggs"),
                Ingredient("200g", "yogurt (Olympus greek yogurt 10%)"),
                Ingredient("160g", "flour 000"),
                Ingredient("", "baking soda"),
                Ingredient("50g", "melted butter"),
            ),
            steps = listOf(
                "Mix everything in the order above",
            )),
    )
}