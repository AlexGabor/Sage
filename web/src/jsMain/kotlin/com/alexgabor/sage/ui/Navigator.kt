package com.alexgabor.sage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.browser.window

class NavigatorState(
    private val root: Route,
    private val routes: List<Route> = emptyList()
) {

    private val _destination: MutableState<Destination> = mutableStateOf(root.toDestination(this))
    val destination: State<Destination> = _destination

    init {
        evaluateLocation(window.location.pathname)
        setOnBackListener()
    }

    fun navigateTo(action: String, replace: Boolean = false) {
        val destination = findDestination(action, routes)
        if (!replace) {
            window.history.pushState(action, destination.route.title, url = action)
        } else {
            window.history.replaceState(action, destination.route.title, url = action)
        }

        this._destination.value = destination
    }

    fun goBack() {
        window.history.back()
    }

    private fun findDestination(pathname: String, routes: List<Route>): Destination {
        val segments = pathname.split("/").filter { it.isNotEmpty() }
        screen@ for (route in routes) {
            val routeSegments = route.url.split("/").filter { it.isNotEmpty() }
            if (routeSegments.size != segments.size) continue
            val capturedSegments = mutableMapOf<String, String>()
            for (index in segments.indices) {
                when {
                    routeSegments[index].startsWith("{") -> {
                        val name = routeSegments[index].drop(1).dropLast(1)
                        capturedSegments[name] = segments[index]
                    }
                    routeSegments[index] != segments[index] -> continue@screen
                }
            }
            return route.toDestination(this, capturedSegments)
        }
        return root.toDestination(this)
    }

    private fun evaluateLocation(pathname: String) {
        _destination.value = findDestination(pathname, routes)
    }

    private fun setOnBackListener() {
        window.onpopstate = {
            evaluateLocation(window.location.pathname)
        }
    }
}

@Composable
fun rememberNavigationState(root: Route, routes: List<Route>): NavigatorState {
    return remember { NavigatorState(root, routes) }
}

@Composable
fun Navigator() {
    val routes = buildList {
        add(Route("Recipes", "/") { navigatorState, _ -> RecipeListScreen(navigatorState) })
        add(Route("Recipe", "/{name}") { navigatorState, captured ->
            RecipeDetailScreen(navigatorState, captured["name"])
        })
    }
    val navigationState = rememberNavigationState(routes[0], routes)

    navigationState.destination.value.Content()
}

data class Route(
    val title: String,
    val url: String,
    val content: @Composable (NavigatorState, Map<String, String>) -> Unit,
)

data class Destination(
    val navigatorState: NavigatorState,
    val capturedPaths: Map<String, String>,
    val route: Route,
) {
    @Composable fun Content() {
        route.content(navigatorState, capturedPaths)
    }
}

fun Route.toDestination(
    navigatorState: NavigatorState,
    capturedPaths: Map<String, String> = emptyMap()
): Destination {
    return Destination(navigatorState, capturedPaths, this)
}

fun String.toPathname(): String = this.lowercase().replace(" ", "-")

