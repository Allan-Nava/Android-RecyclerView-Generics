package com.allannava.recyclerviewgenerics.UXClasses

import android.content.Context
import java.io.IOException

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */
class JsonUtils{
    companion object{

        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}