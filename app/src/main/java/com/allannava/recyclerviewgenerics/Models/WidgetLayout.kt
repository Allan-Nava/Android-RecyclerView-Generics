package com.allannava.recyclerviewgenerics.Models

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */
enum class WidgetLayout(val value: Int, val label: String) {
    //
    HEADER(0, "Header"),
    HIGHLIGHT_CAROUSEL(1, "HighlightCarousel"),
    VIDEO_MATCH_CAROUSEL(2, "VideoMatchCarousel"),
    EVENT_CAROUSEL(3, "EventCarousel"),
    PODCAST_GRID(4, "PodcastGrid"),
    GRID(5,"Grid"),
    VIDEO_GRID(6, "VideoGrid"),
    LONG_CARD_CAROUSEL(7, "LongCardCarousel"),
    API(8, "API"),
    RECTANGULAR_CAROUSEL(9, "RectangularCarousel");
    //
    companion object {
        fun fromValue(value: Int) = values().firstOrNull { it.value == value }
        fun fromLabel(label: String) = values().firstOrNull { it.label == label }
    }
}