import androidx.compose.web.renderComposable
import ui.Navigator

fun main() {
    renderComposable(rootElementId = "root") {
        Navigator()
    }
}