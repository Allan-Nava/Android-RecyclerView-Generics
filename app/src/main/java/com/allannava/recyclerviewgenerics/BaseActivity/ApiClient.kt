package com.allannava.recyclerviewgenerics.BaseActivity

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */
class ApiClient {
    companion object{
        //
        private var retrofit: Retrofit? = null
        // set your desired log level
        // add your other interceptors …
        // <-- this is the important line!
        val client: Retrofit
            get() {
                if ( retrofit == null) {
                    val logging = HttpLoggingInterceptor()
                    logging.level = HttpLoggingInterceptor.Level.BODY
                    val httpClient = OkHttpClient.Builder()
                    httpClient.addInterceptor { chain ->
                        val original = chain.request()
                        val request = original.newBuilder()
                            //.addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B179 Safari/7534.48.3")
                            .addHeader("X-Requested-With", "com.allannava.recyclerviewgenerics")
                            .method(original.method(), original.body())
                            .build()

                        chain.proceed(request)
                    }
                    httpClient.addInterceptor(logging)

                    retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/" )
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return  retrofit!!
            }
        //
    }
}