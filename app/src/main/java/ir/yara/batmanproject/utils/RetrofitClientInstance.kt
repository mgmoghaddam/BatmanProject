package ir.yara.batmanproject.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientInstance {
    companion object{
    private var retrofit: Retrofit? = null
    private val BASE_URL = "http://www.omdbapi.com"
    private var okhttpClient: OkHttpClient? = null

    private fun getRetrofitInstance(): Retrofit? {
        if (okhttpClient == null) {
            okhttpClient = initOkHttp()
        }
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return retrofit
    }

    private fun initOkHttp(): OkHttpClient? {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(7,TimeUnit.SECONDS)
            .build()
    }


        fun getApiService(): ApiCalls? {
            return getRetrofitInstance()
                ?.create(
                    ApiCalls::class.java
                )
        }
    }

}