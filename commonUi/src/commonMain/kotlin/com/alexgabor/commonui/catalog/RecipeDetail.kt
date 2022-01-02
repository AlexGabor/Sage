package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.common.model.Ingredient

@Composable
expect fun Ingredients(ingredients: List<Ingredient>)

@Composable
expect fun Steps(steps: List<String>)