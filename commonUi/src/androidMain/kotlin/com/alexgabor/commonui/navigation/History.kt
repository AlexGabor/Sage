package com.alexgabor.commonui.navigation

actual class NavigationHistory<T : Destination> {
    private val stack: MutableList<T> = mutableListOf()

    actual fun peek(): T? {
        return if (stack.isEmpty()) null
        else stack.last()
    }

    actual fun pop(): T? {
        return if (stack.isNotEmpty()) stack.removeLast() else null
    }

    actual fun push(destination: T) {
        stack.add(destination)
    }
}