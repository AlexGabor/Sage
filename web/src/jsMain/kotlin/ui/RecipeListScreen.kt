package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.web.elements.P
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes
import org.jetbrains.compose.common.foundation.clickable
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Modifier

@Composable
fun RecipeListScreen(onClick: (recipe: Recipe) -> Unit) {
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    RecipeList(recipes, onClick)
}

@Composable
fun RecipeList(recipes: List<Recipe>, onClick: (recipe: Recipe) -> Unit) {
    recipes.forEach { recipe ->
        RecipePreview(recipe, onClick = { onClick(recipe) })
    }
}

@Composable
fun RecipePreview(recipe: Recipe, onClick: () -> Unit) {
    P {
        Text(recipe.name,
            modifier = Modifier.clickable(onClick))
    }
}
