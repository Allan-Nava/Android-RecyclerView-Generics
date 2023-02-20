package com.allannava.recyclerviewgenerics.UXClasses

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allannava.recyclerviewgenerics.Models.WidgetLayout
import com.allannava.recyclerviewgenerics.Models.WidgetViewModel
import com.allannava.recyclerviewgenerics.R

/**
 *   Created by Allan Nava on 19/02/2023.
 *   Updated by Allan Nava on 19/02/2023.
 *
 **/
class LayoutAdapter (var widgetViewModel: WidgetViewModel,): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG = "LayoutAdapter"
    //
    override fun getItemViewType(position: Int): Int {
        val widget = widgetViewModel.widgets.elementAt(position)
        Log.i(TAG, "widget widget ${widget.data} | ${widget.data?.layout}")
        return widget.data!!.layout!!.value
    }
    //
    override fun getItemCount(): Int {
        return widgetViewModel.widgets.size
    }
    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // need to check how to pass the type! and handle the widget name
        // ContentViewHolder<>("")
        Log.i(TAG, "parent $parent | viewType $viewType ")
        if (viewType == WidgetLayout.HEADER.value){
            //return ContentViewHolder<T, TK>
            return ContentViewHolder<ContentLayoutType>( LayoutInflater.from(parent.context).inflate(R.layout.contents_view, parent, false))
        } else if ( viewType == WidgetLayout.HIGHLIGHT_CAROUSEL.value){
            return ContentViewHolder<ContentLayoutType>( LayoutInflater.from(parent.context).inflate(R.layout.contents_view, parent, false))
        }
        return ContentViewHolder<ContentLayoutType>( LayoutInflater.from(parent.context).inflate(R.layout.contents_view, parent, false))
        //
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = widgetViewModel.widgets.elementAt(position)
        //
        if (item.data?.layout == WidgetLayout.HEADER) {
            val view = (viewHolder as ContentViewHolder<*>).contentCard
            view.type = item
        }else{
            val view = (viewHolder as ContentViewHolder<*>).contentCard
            view.type = item
        }
    }
}