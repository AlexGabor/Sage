package com.alexgabor.commonui.navigation

import kotlinx.browser.window

actual object NativeUrlProvider {
    actual fun getRoot(): String {
        return window.location.pathname
    }
}