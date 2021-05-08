import androidx.compose.web.elements.P
import androidx.compose.web.renderComposable
import org.jetbrains.compose.common.material.Text

fun main() {
    renderComposable(rootElementId = "root") {
        (1..10).forEach {
            P {
                Text("Recipe $it")
            }
        }
    }
}