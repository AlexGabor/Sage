import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.web.elements.P
import androidx.compose.web.renderComposable
import com.alexgabor.common.usecase.GetRecipes
import org.jetbrains.compose.common.material.Text

fun main() {
    val getRecipes = GetRecipes()
    renderComposable(rootElementId = "root") {
        val recipes by getRecipes.recipes.collectAsState()
        recipes.forEach {
            P {
                Text("Recipe $it")
            }
        }
    }
}