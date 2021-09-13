package com.example.loweschallenge.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loweschallenge.BuildConfig.API_ID
import com.example.loweschallenge.data.model.WeatherResponseDTO
import com.example.loweschallenge.data.repository.DataRepositoryImpl
import com.example.loweschallenge.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repo: DataRepositoryImpl) : ViewModel() {

    var city = ""
    val dataRepo = repo
    private val _weatherData = MutableLiveData<Resource<WeatherResponseDTO>>()
    private var getForecastJob: Job? = null
    val weather: LiveData<Resource<WeatherResponseDTO>> get() = _weatherData

    var tempDetail = ""
    var feelsLike = ""
    var currWeather = ""
    var weatherDetails = ""


    fun getForecast() {
        getForecastJob = viewModelScope.launch {
            Log.i("viewmodel.city = ", city)
            dataRepo.getData(city, API_ID, "imperial").collect {
                _weatherData.value = it
            }
        }
    }
}