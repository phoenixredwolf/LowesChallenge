package com.example.loweschallenge.data.repository

import android.util.Log
import com.example.loweschallenge.BuildConfig.API_ID
import com.example.loweschallenge.data.remote.WeatherManager
import com.example.loweschallenge.utility.Resource
import kotlinx.coroutines.flow.flow

class DataRepositoryImpl {

    suspend fun getData(
        city: String,
        appid: String,
        units: String
    ) = flow {
        Log.i("city", "repo = $city")
        emit(Resource.Loading)
        val response = WeatherManager.getData(city, API_ID, "imperial")
        val state = if (response.isSuccessful) {
            response.body()?.let {
                Resource.Success(it)
            } ?: Resource.Error("No data found")
        } else Resource.Error("Error fetching data")
        emit(state)
    }

}