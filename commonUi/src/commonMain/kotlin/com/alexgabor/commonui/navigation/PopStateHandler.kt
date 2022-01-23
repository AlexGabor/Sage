package com.alexgabor.commonui.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

value class Handler(val callback: (Direction) -> Boolean)
enum class Direction { Forward, Back }

class PopStateHandler(scope: CoroutineScope, backDispatcher: BackDispatcher) {
    private val handlers = mutableListOf<Handler>()

    init {
        scope.launch {
            backDispatcher.backEvents.collect {
                dispatch(it)
            }
        }
    }

    fun register(handler: Handler) {
        handlers.add(handler)
    }

    fun unregister(handler: Handler) {
        handlers.remove(handler)
    }

    private fun dispatch(direction: Direction): Boolean {
        for (handler in handlers) {
            if (handler.callback.invoke(direction)) {
                return true
            }
        }
        return false
    }
}

interface BackDispatcher {
    val backEvents: Flow<Direction>
}