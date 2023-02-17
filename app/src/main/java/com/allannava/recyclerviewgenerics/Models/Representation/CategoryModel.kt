package com.allannava.recyclerviewgenerics.Models.Representation

import com.allannava.recyclerviewgenerics.Models.Representation.WidgetItemType
import com.google.gson.JsonObject
import java.net.URL

/**
 *   Created by Allan Nava on 17/02/2023.
 *   Updated by Allan Nava on 17/02/2023.
 *
 **/
class CategoryModel(jsonObject: JsonObject) : WidgetItemType {
    var id : Int? = null
    var idString : String? = ""
    var title : String = ""
    var subTitle: String? = ""
    var image : String = ""
    var type: String? = ""

    init {
        jsonObject.get("id").let {
            if(it.asJsonPrimitive.isString){
                this.id = Integer.parseInt(it.asString)
                this.idString = it.asString
            }else{
                this.id = it.asInt
            }
        }
        jsonObject.get("title").let{
            this.title = it.asString
        }
        jsonObject.get("subtitle").let{
            this.subTitle = it.asString
        }
        jsonObject.get("image").let{
            this.image = it.asString
        }
        jsonObject.get("type").let{
            this.type = it.asString
        }
    }
}