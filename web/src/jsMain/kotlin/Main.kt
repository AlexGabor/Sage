import com.alexgabor.sage.ui.SageApp
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        SageApp()
    }
}