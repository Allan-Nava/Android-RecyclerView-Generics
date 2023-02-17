package com.allannava.recyclerviewgenerics.Models.Representation

import android.net.Uri
import androidx.core.net.toUri
import com.google.gson.JsonObject

/**
 *   Created by Allan Nava on 17/02/2023.
 *   Updated by Allan Nava on 17/02/2023.
 *
 **/
class GalleryModel(jsonObject: JsonObject) : WidgetItemType {

    var id: Int?= null
    var idString: String?= ""
    var title: String?= ""
    var backgroundImage: Uri?= null
    var date: String?= ""
    var totalImages: String?= ""
    var registration: String? = "0"

    init{
        jsonObject.get("id").let {
            if(it.asJsonPrimitive.isString){
                this.id = Integer.parseInt(it.asString)
                this.idString = it.asString
            }else{
                this.id = it.asInt
            }
        }
        jsonObject.get("title").let {
            title = it.asString
        }
        jsonObject.get("background_image").let {
            backgroundImage = it.asString.toUri()
        }
        jsonObject.get("date").let {
            date = it.asString
        }
        jsonObject.get("total_images").let {
            totalImages = it.asString
        }
        jsonObject.get("registration").let {
            registration = it.asString
        }
    }

}