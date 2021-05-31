package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.web.css.height
import androidx.compose.web.css.marginLeft
import androidx.compose.web.css.marginTop
import androidx.compose.web.css.px
import androidx.compose.web.css.value
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.P
import com.alexgabor.common.model.Recipe
import com.alexgabor.common.usecase.GetRecipes
import org.jetbrains.compose.common.foundation.clickable
import org.jetbrains.compose.common.material.Text
import org.jetbrains.compose.common.ui.Modifier
import ui.catalog.AppTitle

@Composable
fun RecipeListScreen(onClick: (recipe: Recipe) -> Unit) {
    val getRecipes = remember { GetRecipes() }
    val recipes by getRecipes.recipes.collectAsState()

    Div(style = {
        property("max-width", value(680.px))
        property("margin", value("0 auto"))
    }) {
        Div(style = {
            marginLeft(16.px)
            property("margin-right", value(16.px))
        }) {
            Div(style = {
                height(16.px)
            }) { }
            AppTitle()
            RecipeList(recipes, onClick)
        }
    }
}

@Composable
fun RecipeList(recipes: List<Recipe>, onClick: (recipe: Recipe) -> Unit) {
    recipes.forEach { recipe ->
        RecipePreview(recipe, onClick = { onClick(recipe) })
    }
}

@Composable
fun RecipePreview(recipe: Recipe, onClick: () -> Unit) {
    P(style = {
        marginTop(16.px)
    }) {
        Text(recipe.name,
            modifier = Modifier.clickable(onClick))
    }
}
