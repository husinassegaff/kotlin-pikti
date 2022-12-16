package com.example.learn_kotlin.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface IOpenWeatherMap {
    @GET("weather")
    fun getWeatherByLatLng(@Query("lat") lat: String,
                           @Query("lon") lon: String,
                           @Query("appid") appid: String,
                           @Query("units") units: String): Observable<WeatherResult>

    @GET("forecast")
    fun getForecastWeatherByLatLng(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String
    ) : Observable<WeatherForecastResponse>

}