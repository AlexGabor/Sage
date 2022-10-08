package com.alexgabor.sage.pages

import androidx.compose.runtime.Composable
import com.alexgabor.sage.ui.catalog.Screen
import com.alexgabor.sage.ui.catalog.typography.Body
import com.varabyte.kobweb.core.Page

@Page("404")
@Composable
fun NotFound() {
    Screen {
        Body("Not found")
    }
}