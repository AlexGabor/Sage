package com.alexgabor.commonui.navigation

import kotlinx.browser.window
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class JsBackDispatcher : BackDispatcher {
    private val _backEvents = MutableSharedFlow<Direction>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    override val backEvents: Flow<Direction> = _backEvents
    private var previous: Int = 0

    init {
        window.onpopstate = {
            val newState = it.state?.toString()?.toInt()
            _backEvents.tryEmit(
                if (newState == null || newState < previous) {
                    Direction.Back
                } else {
                    Direction.Forward
                }
            )
            previous = newState ?: 0
            Unit
        }
    }
}