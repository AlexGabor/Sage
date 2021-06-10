package com.alexgabor.sage.ui.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppTitle() {
    Column(Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color(0xff494949)))
        BasicText(text = "Sage")
    }
}
