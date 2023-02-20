package com.allannava.recyclerviewgenerics.Models.Representation

import android.net.Uri
import androidx.core.net.toUri
import com.google.gson.JsonObject

/**
 *   Created by Allan Nava on 17/02/2023.
 *   Updated by Allan Nava on 17/02/2023.
 *
 **/
class MatchModel(jsonObject: JsonObject) : WidgetItemType {

    var id: Int?= null
    var idString: String?= ""
    var name: String?= ""
    var status: String?= ""
    var active: String?= ""
    var date: String?= ""
    var time: String?= ""
    var image: Uri?= null
    var backupImage: Uri?= null
    var awayTeam: String?= ""
    var homeTeam: String?= ""

    var awayTeamLogo: Uri?= null
    var homeTeamLogo: Uri?= null
    var awayTeamSecondaryLogo: Uri?= null
    var homeTeamSecondaryLogo: Uri?= null
    var awayTeamActive: String?= ""
    var homeTeamActive: String?= ""
    var awayTeamScore: String?= ""
    var homeTeamScore: String?= ""
    var championshipTitle: String?= ""
    var championshipImage: Uri?= null
    var championshipBgImage: Uri?= null
    var matchDayTitle: String?= ""
    var tournamentTitle: String?= ""
    var stageTitle: String?= ""
    var venueName: String?= ""
    var registration: String?= ""
    var ticketUrl: String?= ""

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
            if(it!=null) {
                name = it.asString
            }
        }
        jsonObject.get("status").let {
            if(it!=null) {
                status = it.asString
            }
        }
        jsonObject.get("active").let {
            if(it!=null) {
                active = it.asString
            }
        }
        jsonObject.get("date").let {
            date = it.asString
        }
        jsonObject.get("time").let {
            time = it.asString
        }
        jsonObject.get("image").let {
            image = it.asString.toUri()
        }
        jsonObject.get("backup_image").let {
            backupImage = it.asString.toUri()
        }
        jsonObject.get("away_team").let {
            awayTeam = it.asString
        }
        jsonObject.get("home_team").let {
            homeTeam = it.asString
        }
        jsonObject.get("away_team_logo").let {
            awayTeamLogo = it.asString.toUri()
        }
        jsonObject.get("home_team_logo").let {
            homeTeamLogo = it.asString.toUri()
        }
        jsonObject.get("away_team_secondary_logo").let {
            awayTeamSecondaryLogo = it.asString.toUri()
        }
        jsonObject.get("home_team_secondary_logo").let {
            homeTeamSecondaryLogo = it.asString.toUri()
        }
        jsonObject.get("away_team_active").let {
            awayTeamActive = it.asString
        }
        jsonObject.get("home_team_active").let {
            homeTeamActive = it.asString
        }
        jsonObject.get("away_team_score").let {
            awayTeamScore = it.asString
        }
        jsonObject.get("home_team_score").let {
            homeTeamScore = it.asString
        }
        jsonObject.get("championship_title").let {
            championshipTitle = it.asString
        }
        jsonObject.get("championship_image").let {
            championshipImage = it.asString.toUri()
        }
        jsonObject.get("championship_bg_image").let {
            championshipBgImage = it.asString.toUri()
        }
        jsonObject.get("match_day_title").let {
            matchDayTitle = it.asString
        }
        jsonObject.get("tournament_title").let {
            tournamentTitle = it.asString
        }
        jsonObject.get("stage_title").let {
            stageTitle = it.asString
        }
        jsonObject.get("venue_name").let {
            venueName = it.asString
        }
        jsonObject.get("registration").let {
            registration = it.asString
        }
        jsonObject.get("ticket_url").let {
            ticketUrl = it.asString
        }
    }
}