package com.example.loweschallenge.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val timezone: Int
)