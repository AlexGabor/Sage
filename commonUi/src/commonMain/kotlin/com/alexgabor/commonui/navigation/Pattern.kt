package com.alexgabor.commonui.navigation

data class Pattern(
    val segments: List<Segment>
) {
    companion object {
        fun ofString(url: String): Pattern = Pattern(
            segments = url.split("/").map {
                if (!it.startsWith("{")) Segment.Path(it)
                else Segment.Matcher(it.substring(1 until (it.length - 1)))
            })
    }
}

sealed class Segment {
    class Path(val value: String) : Segment()
    class Matcher(val value: String) : Segment()
}