package com.allannava.recyclerviewgenerics.Models.Representation

import android.net.Uri
import androidx.core.net.toUri
import androidx.core.text.htmlEncode
import com.allannava.recyclerviewgenerics.Models.Representation.WidgetItemType
import com.google.gson.JsonObject

/**
 *   Created by Allan Nava on 17/02/2023.
 *   Updated by Allan Nava on 17/02/2023.
 *
 **/
class ContentModel(jsonObject: JsonObject) : WidgetItemType {
    var id: Int?= null
    var idString: String?= ""
    var overTitle: String?= ""
    var title: String?= ""
    var subTitle: String?= ""
    var image: Uri?= null
    var backupImage: Uri?= null
    var mainImage: Uri?= null
    var secondaryImage: Uri?= null
    var backgroundImage: Uri?= null
    var videoUrl: Uri?= null
    var body: String?= ""
    var intro: String?= ""
    var category: String?= ""
    var author: String?= ""
    var broadcast: String?= ""
    var speaker: String?= ""
    var type: String?= ""
    var registration: String?= ""
    var speakers: String?= ""
    var date: String?= ""

    init {
        jsonObject.get("id").let {
            if(it.asJsonPrimitive.isString){
                this.id = Integer.parseInt(it.asString)
                this.idString = it.asString
            }else{
                this.id = it.asInt
            }
        }
        jsonObject.get("overtitle").let {
            overTitle = it.asString
        }
        jsonObject.get("title").let {
            title = it.asString
        }
        jsonObject.get("subtitle").let {
            subTitle = it.asString
        }
        jsonObject.get("image").let {
            image = it.asString.toUri()
        }
        jsonObject.get("backup_image").let {
            backupImage = it.asString.toUri()
        }
        jsonObject.get("main_image").let {
            mainImage = it.asString.toUri()
        }
        jsonObject.get("secondary_image").let {
            secondaryImage = it.asString.toUri()
        }
        jsonObject.get("background_image").let {
            backgroundImage = it.asString.toUri()
        }
        jsonObject.get("video_url").let {
            videoUrl = it.asString.toUri()
        }
        jsonObject.get("body").let{
            body = it.asString.htmlEncode()
        }
        jsonObject.get("intro").let {
            intro = it.asString
        }
        jsonObject.get("category").let {
            category = it.asString
        }
        jsonObject.get("author").let{
            author = it.asString
        }
        jsonObject.get("broadcast").let{
            broadcast = it.asString
        }
        jsonObject.get("speaker").let{
            speaker = it.asString
        }
        jsonObject.get("registration").let{
            registration = it.asString
        }
        jsonObject.get("speakers").let{
            speakers = it.asString
        }
        jsonObject.get("date").let{
            date = it.asString
        }
    }
}