package com.allannava.recyclerviewgenerics.Models.Representation

import android.net.Uri
import androidx.core.net.toUri
import com.allannava.recyclerviewgenerics.Models.Representation.WidgetItemType
import com.google.gson.JsonObject

/**
 *   Created by Allan Nava on 17/02/2023.
 *   Updated by Allan Nava on 17/02/2023.
 *
 **/
class MediaModel(jsonObject: JsonObject) : WidgetItemType {

    var title: String?= ""
    var subtitle: String?= ""
    var image: Uri?= null

    init{
        jsonObject.get("title").let {
            title = it.asString
        }
        jsonObject.get("subtitle").let {
            subtitle = it.asString
        }
        jsonObject.get("image").let {
            image = it.asString.toUri()
        }
    }

}