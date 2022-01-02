package com.alexgabor.commonui.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class NavigationController<T : Destination> {

    private val _destination = MutableStateFlow<T?>(null)
    val destination: StateFlow<T?> = _destination

    private val history: NavigationHistory<T> = NavigationHistory()

    fun navigateTo(destination: T) {
        history.push(destination)
        _destination.value = destination
    }

    fun goBack(): T? = history.pop()
}

interface Destination {
    val url: String
}