package com.alexgabor.commonui.catalog

import androidx.compose.runtime.Composable
import com.alexgabor.common.model.Recipe


@Composable
expect fun RecipePreview(recipe: Recipe, onClick: () -> Unit)