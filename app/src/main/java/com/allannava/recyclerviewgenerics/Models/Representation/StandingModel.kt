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
class StandingModel(jsonObject: JsonObject) : WidgetItemType {

    var id: Int?= null
    var idString: String?= ""
    var name: String?= ""
    var active: String?= ""
    var image: Uri?= null
    var secondaryImage: Uri?= null
    var rank: Int?= null
    var lastRank: Int?= null
    var rankStatus: String? = ""
    var points: Int?= null
    var matchesPlayed: Int?= null
    var matchesWon: Int?= null
    var matchesDrawn: Int?= null
    var matchesLost: Int?= null
    var goalsFor: Int?= null
    var goalsAgainst: Int?= null
    var goalsDifference: String?= ""

    init{
        jsonObject.get("id").let {
            if(it.asJsonPrimitive.isString){
                this.id = Integer.parseInt(it.asString)
                this.idString = it.asString
            }else{
                this.id = it.asInt
            }
        }
        jsonObject.get("name").let {
            name = it.asString
        }
        jsonObject.get("active").let {
            active = it.asString
        }
        jsonObject.get("image").let {
            image = it.asString.toUri()
        }
        jsonObject.get("secondary_image").let {
            secondaryImage = it.asString.toUri()
        }
        jsonObject.get("rank").let {
            rank = it.asInt
        }
        jsonObject.get("lastRank").let {
            lastRank = it.asInt
        }
        jsonObject.get("rankStatus").let {
            rankStatus = it.asString
        }
        jsonObject.get("points").let {
            points = it.asInt
        }
        jsonObject.get("matches_played").let {
            matchesPlayed = it.asInt
        }
        jsonObject.get("matches_won").let {
            matchesWon = it.asInt
        }
        jsonObject.get("matches_drawn").let {
            matchesDrawn = it.asInt
        }
        jsonObject.get("matches_lost").let {
            matchesLost = it.asInt
        }
        jsonObject.get("goals_for").let {
            goalsFor = it.asInt
        }
        jsonObject.get("goals_against").let {
            goalsAgainst = it.asInt
        }
        jsonObject.get("goals_difference").let {
            goalsDifference = it.asString
        }
    }
}