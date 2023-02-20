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
class PersonModel(jsonObject: JsonObject) : WidgetItemType {
    var id: Int?= null
    var idString: String?= ""
    var name: String?= ""
    var surname: String?= ""
    var shortName: String?= ""
    var nationality: String?= ""
    var codRole: String?= ""
    var image: Uri?= null
    var mediumShot: Uri?=null
    var uniformNumber: String?= ""
    var type: String?= ""
    var order: String?= ""
    var birthDay: String?= ""

    init {
        jsonObject.get("id").let {
            if(it.asJsonPrimitive.isString){
                this.id = Integer.parseInt(it.asString)
                this.idString = it.asString
            }else{
                this.id = it.asInt
            }
        }
        jsonObject.get("name").let {
            if(it!=null) {
                name = it.asString
            }
        }
        jsonObject.get("surname").let {
            if(it!=null) {
                surname = it.asString
            }
        }
        jsonObject.get("short_name").let {
            if(it!=null) {
                shortName = it.asString
            }
        }
        jsonObject.get("nationality").let {
            if(it!=null) {
                nationality = it.asString
            }
        }
        jsonObject.get("cod_role").let {
            if(it!=null) {
                codRole = it.asString
            }
        }
        jsonObject.get("image").let {
            if(it!=null) {
                image = it.asString.toUri()
            }
        }
        jsonObject.get("medium_shot").let {
            if(it!=null) {
                mediumShot = it.asString.toUri()
            }
        }
        jsonObject.get("uniform_number").let {
            if(it!=null) {
                uniformNumber = it.asString
            }
        }
        jsonObject.get("type").let {
            if(it!=null) {
                type = it.asString
            }
        }
        jsonObject.get("order").let {
            order = it.asString
        }
        jsonObject.get("birth_day").let {
            birthDay = it.asString
        }
    }
}