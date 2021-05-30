package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.web.elements.P
import androidx.compose.web.elements.Text
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    recipe.ingredients.forEach {
        P { Text("${it.quantity} ${it.name}") }
    }
}

@Composable
fun RecipeDetailScreen(pathname: String, onNotFound: () -> Unit) {
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    val recipe = remember(pathname) { recipes.find { it.name.toPathname() == pathname } }

    if (recipe != null) {
        RecipeDetailScreen(recipe)
    } else {
        onNotFound()
    }
}