package com.allannava.recyclerviewgenerics.Models.Representation

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */

class MutableCollectionWidgetItem<T> where T : WidgetItemType {
    private val items: MutableList<T> = mutableListOf()
    /**
     * Add the item in the collection.
     */
    fun addItem(item: T) {
        items.add(item)
    }

    /**
     * Add the item in the collection.
     */
    fun addAll(list: Collection<T>) {
        items.addAll(list)
    }
    /**
     * Returns the list of the collection.
     */
    fun getItems(): List<T> {
        return items
    }
    /**
     * Returns the size of the collection.
     */
    fun size(): Int {
        return items.size
    }
    /**
     * Returns an element at the given index or throws an IndexOutOfBoundsException if the index is out of bounds of this collection.
     */
    fun elementAt(i: Int): T {
        return items[i]
    }
    /**
    * */
    fun clear() {
        items.clear()
    }

}
//
interface WidgetItemType