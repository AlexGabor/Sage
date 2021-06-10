import androidx.compose.web.renderComposable
import com.alexgabor.sage.ui.SageApp

fun main() {
    renderComposable(rootElementId = "root") {
        SageApp()
    }
}