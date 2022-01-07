package com.alexgabor.commonui.navigation

import kotlinx.browser.window


actual class NavigationHistory<T : Destination> {
    private val stack: MutableList<T> = mutableListOf()

    actual fun peek(): T? {
        return if (stack.isEmpty()) null
        else stack.last()
    }

    actual fun pop(): T? {
//        window.history.back()
        return if (stack.isNotEmpty()) stack.removeLast() else null
    }

    actual fun push(destination: T) {
        window.history.pushState(destination, "", url = window.location.origin + destination.path)
        stack.add(destination)
    }
}
