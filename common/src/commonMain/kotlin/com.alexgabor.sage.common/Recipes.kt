package com.alexgabor.sage.common

import com.alexgabor.sage.common.model.Ingredient
import com.alexgabor.sage.common.model.Recipe

val Recipes = listOf(
    Recipe("Pancakes",
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
        )),
    Recipe("Waffles",
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