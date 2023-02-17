package com.allannava.recyclerviewgenerics.Models

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */

enum class WidgetName(val value: Int, val label: String) {
    //
    CATEGORY_REPRESENTATION(0, "CategoryRepresentation"),
    CONTENT_REPRESENTATION(1, "ContentRepresentation"),
    GALLERY_REPRESENTATION(2, "GalleryRepresentation"),
    GALLERY_ITEM_REPRESENTATION(3, "GalleryItemRepresentation"),
    MATCH_CARD_REPRESENTATION(4, "MatchCardCarousel"),
    MATCH_REPRESENTATION(5, "MatchRepresentation"),
    MEDIA_REPRESENTATION(6, "MediaRepresentation"),
    NEXT_MATCH(7, "NextMatch"),
    STANDING_TABLE(8, "StandingTable"),
    VIDEO_MATCH_CAROUSEL(9, "VideoMatchCarousel");
    //
    companion object {
        fun fromValue(value: Int) = values().firstOrNull { it.value == value }
        fun fromLabel(label: String) = values().firstOrNull { it.label == label }
    }
    //
}