import androidx.compose.web.renderComposable
import ui.SageApp

fun main() {
    renderComposable(rootElementId = "root") {
        SageApp()
    }
}