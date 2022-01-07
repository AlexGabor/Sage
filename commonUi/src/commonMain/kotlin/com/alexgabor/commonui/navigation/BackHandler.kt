package com.alexgabor.commonui.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

value class Handler(val callback: () -> Boolean)

class BackHandler(scope: CoroutineScope, backDispatcher: BackDispatcher) {
    private val handlers = mutableListOf<Handler>()

    init {
        scope.launch {
            backDispatcher.backEvents.collect {
                dispatch()
            }
        }
    }

    fun register(handler: Handler) {
        handlers.add(handler)
    }

    fun unregister(handler: Handler) {
        handlers.remove(handler)
    }

    private fun dispatch(): Boolean {
        for (handler in handlers) {
            if (handler.callback.invoke()) {
                return true
            }
        }
        return false
    }
}

interface BackDispatcher {
    val backEvents: Flow<Unit>
}