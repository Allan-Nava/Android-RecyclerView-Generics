package com.allannava.recyclerviewgenerics.UXClasses

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.allannava.recyclerviewgenerics.Models.Representation.MutableCollectionWidgetItem
import com.allannava.recyclerviewgenerics.Models.Representation.WidgetItemType
import com.allannava.recyclerviewgenerics.Models.Widget
import com.allannava.recyclerviewgenerics.R

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */

class ContentsCell<T> : LinearLayout {
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    //
    //lateinit var presenter:  BaseVideoContracts.Presenter
    //
    private val adapter: ContentAdapter<T> = ContentAdapter()
    override fun onFinishInflate() {
        super.onFinishInflate()
        recyclerView = findViewById(R.id.recyclerViewContents)
    }

    var recyclerView: RecyclerView? = null
        set(value) {
            field = value
            val layoutManager           = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView?.layoutManager = layoutManager
            recyclerView?.adapter       = adapter
            recyclerView?.setHasFixedSize(true)
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
            //
        }
    //
    var items: MutableCollectionWidgetItem<WidgetItemType> = MutableCollectionWidgetItem()
    var type: Widget? = null
        set(value) {
            field = value
            items.clear()
            if (value != null) {
                value.items?.let {
                    items.addAll(it)
                    adapter.items = it
                }
            }
            adapter.notifyDataSetChanged()
        }
}