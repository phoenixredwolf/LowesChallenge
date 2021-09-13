package com.example.loweschallenge.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponseDTO(
    val city: City,
    val cnt: Int,
    val cod: String,
    @Json(name="list")
    val weather: List<WeatherDetails>,
    val message: Int
)