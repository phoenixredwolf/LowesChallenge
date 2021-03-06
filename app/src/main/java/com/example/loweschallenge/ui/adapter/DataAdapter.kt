package com.example.loweschallenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loweschallenge.data.model.WeatherDetails
import com.example.loweschallenge.data.model.WeatherResponseDTO
import com.example.loweschallenge.databinding.ForecastItemBinding

class DataAdapter(
    private val weather: List<WeatherDetails>,
    private val itemClicked: (WeatherDetails) -> Unit
) : RecyclerView.Adapter<DataAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = WeatherViewHolder.inflate(parent).also { holder ->
        holder.itemView.setOnClickListener {
            itemClicked.invoke(weather[holder.adapterPosition])
        }
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int): Unit = with(holder) {
        bind(weather[position].weather.description, weather[position].main.temp.toString())
    }

    override fun getItemCount() = weather.size

    class WeatherViewHolder(
        private val binding: ForecastItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weatherDet: String, temp:String) = with(binding) {
            tvWeather.text = weatherDet
            tvTemp.text = temp
        }

        companion object {
            fun inflate(parent: ViewGroup) = WeatherViewHolder(
                ForecastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
}