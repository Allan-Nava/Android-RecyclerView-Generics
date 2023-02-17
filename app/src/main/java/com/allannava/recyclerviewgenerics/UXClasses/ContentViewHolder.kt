package com.allannava.recyclerviewgenerics.UXClasses

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */

interface ContentLayoutType

//
class ContentViewHolder<TL> internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) where TL : ContentLayoutType {
    internal var contentCard : ContentsCell<TL> = itemView as ContentsCell<TL>
}