package com.alexgabor.commonui.navigation

import kotlinx.browser.window
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class JsBackDispatcher : BackDispatcher {
    private val _backEvents = MutableSharedFlow<Unit>(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    override val backEvents: Flow<Unit> = _backEvents

    init {
        window.onpopstate = {
            _backEvents.tryEmit(Unit)
        }
    }
}