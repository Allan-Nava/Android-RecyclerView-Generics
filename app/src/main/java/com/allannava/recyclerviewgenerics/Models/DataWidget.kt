package com.allannava.recyclerviewgenerics.Models

import com.google.gson.JsonObject

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */

class DataWidget(jsonObject: JsonObject) {
    //
    var total: Int?         = null
    var limit : String      = ""
    var title : String      = ""
    var endpoint : String   = ""
    var category: MutableCollection<String>? = mutableListOf()
    var layout: WidgetLayout? = null
    //
    init {
        if(jsonObject.has("limit"))
            limit = jsonObject.get("limit").asString
        if(jsonObject.has("total"))
            total = jsonObject.get("total").asInt
        if(jsonObject.has("title")) {
            title = jsonObject.get("title").asString
        }
        if (jsonObject.has("id_category")){
            val idCategory = jsonObject.get("id_category").asString
            category = idCategory.split(" ").toMutableList()
            //category = jsonObject.get("category").asString
        }
        if(jsonObject.has("layout")){
            layout = WidgetLayout.valueOf(jsonObject.get("layout").asString)
        }
        jsonObject.get("endpoint").let{
            endpoint = it.asString
        }
    }
    //
}