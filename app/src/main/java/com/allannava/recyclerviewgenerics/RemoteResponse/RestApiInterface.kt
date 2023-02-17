package com.allannava.recyclerviewgenerics.RemoteResponse

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */
interface RestApiInterface {
    ///
    @FormUrlEncoded
    @POST("auth-login/")
    fun loginUser( @FieldMap params: Map<String, String> ): Call<JsonObject>
    ///
}