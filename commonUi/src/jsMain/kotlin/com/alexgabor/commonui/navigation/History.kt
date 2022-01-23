package com.alexgabor.commonui.navigation

import kotlinx.browser.window


actual class NavigationHistory<T : Destination> {
    private val stack: MutableList<T> = mutableListOf()
    private var stackIndex = -1

    actual fun peek(): T? {
        return if (stackIndex == -1) null
        else stack[stackIndex]
    }

    actual fun pop(): T? {
        return if (stackIndex > -1) {
            stack[stackIndex].also { stackIndex -= 1 }
        } else null
    }

    actual fun push(destination: T) {
        window.history.pushState(
            stack.size, "", url = window.location.origin + destination.path
        )
        for (index in stackIndex.coerceAtLeast(0) until stack.size) {
            stack.removeAt(index)
        }
        stack.add(destination)
        stackIndex = stack.size - 1
    }

    actual fun push(): T? {
        if (stackIndex == stack.size - 1) return null
        stackIndex = (stackIndex + 1).coerceAtMost(stack.size - 1)
        return stack[stackIndex]
    }
}
