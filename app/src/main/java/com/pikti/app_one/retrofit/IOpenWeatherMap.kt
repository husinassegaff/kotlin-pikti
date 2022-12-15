package com.pikti.app_one.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.Observable

interface IOpenWeatherMap {
    @GET("weather")
    fun getWeatherByLatLng(@Query("lat") lat : String,
                           @Query("lng") lng : String,
                           @Query("appid") appid: String,
                           @Query("units") units: String): Observable<WeatherResult>
}