import com.alexgabor.sage.SageApp
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        SageApp()
    }
}