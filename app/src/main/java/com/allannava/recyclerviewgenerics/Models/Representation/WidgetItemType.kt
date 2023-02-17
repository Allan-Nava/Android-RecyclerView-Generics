package com.allannava.recyclerviewgenerics.Models.Representation

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */

class MutableCollectionWidgetItem<T> where T : WidgetItemType {
    private val items: MutableList<T> = mutableListOf()

    fun addItem(item: T) {
        items.add(item)
    }

    fun getItems(): List<T> {
        return items
    }
}
//
interface WidgetItemType