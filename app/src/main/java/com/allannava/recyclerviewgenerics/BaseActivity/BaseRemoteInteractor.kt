package com.allannava.recyclerviewgenerics.BaseActivity

import com.allannava.recyclerviewgenerics.RemoteResponse.RestApiInterface

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */
open class BaseRemoteInteractor {
    //
    val apiService: RestApiInterface =  ApiClient.client.create(RestApiInterface::class.java)
    //
}