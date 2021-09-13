package com.example.loweschallenge.data.remote

import com.example.loweschallenge.BuildConfig.API_ID
import com.example.loweschallenge.data.model.WeatherResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getData(
        @Query("q") city: String,
        @Query("appid") apiKey: String = API_ID,
        @Query("units") units: String = "imperial"
    ) : Response<WeatherResponseDTO>
}