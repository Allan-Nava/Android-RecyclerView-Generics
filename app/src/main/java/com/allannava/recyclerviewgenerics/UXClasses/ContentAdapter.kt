package com.allannava.recyclerviewgenerics.UXClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allannava.recyclerviewgenerics.Models.Representation.MutableCollectionWidgetItem
import com.allannava.recyclerviewgenerics.Models.Representation.WidgetItemType
import com.allannava.recyclerviewgenerics.R

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */
class ContentAdapter<T> : RecyclerView.Adapter<ContentAdapter.ViewHolder<T>>() {
    //
    private var mLastClickTime : Long = 0
    var items: MutableCollectionWidgetItem<WidgetItemType> = MutableCollectionWidgetItem()
    private val TAG = "ContentAdapter"
    //
    override fun getItemCount(): Int {
        return items.size()
    }
    //
    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        val item = items.elementAt(position)
        //holder.card.layoutWithItemWidget( item )
        /*holder.card.button.setOnClickListener {
            //Log.i("SliderAdapter", "onBindViewHolder clicked  ${item.} | ${item.image}")
            // mis-clicking prevention, using threshold of 1000 ms
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()
            //
            //presenter.loadVideoInfo(item)
        }*/
        return
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        // need to understand how to inflate the correct layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_view, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // var card: ContentCell<T> = itemView.findViewById(R.id.card_slider)
    }
    //
}