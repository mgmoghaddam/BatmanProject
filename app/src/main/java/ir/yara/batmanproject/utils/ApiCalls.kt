package ir.yara.batmanproject.utils

import io.reactivex.Observable
import ir.yara.batmanproject.model.FirstApi
import ir.yara.batmanproject.model.SecondApi
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCalls {

    @GET("/?apikey=3e974fca&s=batman")
    fun firstApi(): Observable<FirstApi>


    @GET("/?apikey=3e974fca&i={imdbID}")
    fun secondApi(
        @Path("imdbID") version_key: String?
    ): Observable<SecondApi>?
}