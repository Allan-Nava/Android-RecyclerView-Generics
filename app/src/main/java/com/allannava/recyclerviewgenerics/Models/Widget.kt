package com.allannava.recyclerviewgenerics.Models

import com.allannava.recyclerviewgenerics.Models.Representation.*
import com.google.gson.JsonObject

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */
class Widget(jsonObject: JsonObject) {
    lateinit var name : WidgetName
    var items : MutableCollection<WidgetItemType>? = null
    var data: DataWidget? = null
    //
    init {
        if(jsonObject.has("name")){
            this.name = WidgetName.valueOf(jsonObject.get("name").asString)
        }
        jsonObject.get("body").let { body ->
            // If body is not null.
            if (body.isJsonArray){
                for( dict in body.asJsonArray) {
                    if(dict.isJsonObject){
                        val item = createRepresentation(jsonObject= dict as JsonObject,
                            widgetRepresentation =  this.name )
                        items?.add(item)
                    }
                }
            } else if( body.isJsonObject ){
                body.asJsonObject.get("items").let{
                    for( dict in it.asJsonArray) {
                        if(dict.isJsonObject){
                            val item = createRepresentation(jsonObject= dict as JsonObject,
                                widgetRepresentation =  this.name )
                            items?.add(item)
                        }
                    }
                }
            }
        }
        jsonObject.get("data").let { data ->
            if(data.isJsonObject){
                this.data = DataWidget(data.asJsonObject)
            }
        }
    }
    //
    companion object{
        //
        fun createRepresentation(jsonObject: JsonObject, widgetRepresentation: WidgetName) : WidgetItemType {
            return when (widgetRepresentation) {
                WidgetName.CATEGORY_REPRESENTATION -> CategoryModel(jsonObject)
                WidgetName.CONTENT_REPRESENTATION -> ContentModel(jsonObject)
                WidgetName.GALLERY_ITEM_REPRESENTATION -> GalleryItemModel(jsonObject)
                WidgetName.GALLERY_REPRESENTATION -> GalleryModel(jsonObject)
                WidgetName.NEXT_MATCH, WidgetName.MATCH_CARD_REPRESENTATION, WidgetName.VIDEO_MATCH_CAROUSEL  -> MatchModel(jsonObject)
                WidgetName.MEDIA_REPRESENTATION -> MediaModel(jsonObject)
                WidgetName.STANDING_TABLE -> StandingModel(jsonObject)
                else -> {
                    print("else case ContentModel")
                    ContentModel(jsonObject)
                }
            }
        }
    }
    //
}