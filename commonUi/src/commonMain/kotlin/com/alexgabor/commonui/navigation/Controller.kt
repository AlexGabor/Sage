package com.alexgabor.commonui.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class NavigationController<T : Destination>(initial: T?) {

    private val _destination = MutableStateFlow<T?>(initial)
    val destination: StateFlow<T?> = _destination

    private val history: NavigationHistory<T> = NavigationHistory()

    fun navigateTo(destination: T) {
        history.push(destination)
        _destination.value = destination
    }

    fun goBack(): T? {
        return history.pop().also {
            _destination.value = history.peek()
        }
    }
}

interface Destination {
    val path: String
}