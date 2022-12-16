package com.example.learn_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learn_kotlin.common.Common
import com.example.learn_kotlin.databinding.ItemWeatherForecastBinding
import com.example.learn_kotlin.retrofit.ListItem
import com.squareup.picasso.Picasso

class WeatherForecastAdapter(private val weatherForecastAdapter: ArrayList<ListItem>, val context: Context) :  RecyclerView.Adapter<WeatherForecastAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemWeatherForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val weatherForecast = weatherForecastAdapter[position]
        var temp = weatherForecast.main?.temp
        temp = temp?.minus(273.15)

        with(holder.binding) {
            Picasso.get().load("https://openweathermap.org/img/w/${weatherForecast.weather.get(0).icon}.png").into(imgWeather)
            txtDate.text = StringBuilder("${Common.convertUnixToDate(weatherForecast.dt)}")
            txtDescription.text = StringBuilder(weatherForecast.weather.get(0).description)
            txtTemperature.text = StringBuilder("${temp?.let { Math.round(it) }}°C")
        }
    }

    class RecyclerViewHolder(var binding: ItemWeatherForecastBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return weatherForecastAdapter.size
    }
}