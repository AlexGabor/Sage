package com.alexgabor.commonui.navigation

import kotlinx.browser.window


actual class NavigationHistory<T : Destination> {
    private val stack: MutableList<T> = mutableListOf()

    actual fun pop(): T? {
        window.history.back()
        return if (stack.isNotEmpty()) stack.removeLast() else null
    }

    actual fun push(destination: T) {
        window.history.pushState(destination, "", url = destination.url)
        stack.add(destination)
    }
}
