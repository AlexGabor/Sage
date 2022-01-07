package com.alexgabor.commonui.navigation

expect class NavigationHistory<T : Destination>() {
    fun push(destination: T)
    fun pop(): T?
    fun peek(): T?
}