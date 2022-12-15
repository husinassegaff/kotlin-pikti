package com.example.learn_kotlin.adapter

import android.content.Context
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learn_kotlin.common.Common
import com.example.learn_kotlin.databinding.ItemWeatherForecastBinding
import com.example.learn_kotlin.retrofit.ListItem
import com.squareup.picasso.Picasso

class WeatherForecastAdapter(private val weatherForecastAdapter: ArrayList<ListItem>, val context: Context) : RecyclerView.Adapter<WeatherForecastAdapter.RecyclerViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemWeatherForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val weatherForecast = weatherForecastAdapter[position]
        with(holder.binding){
            Picasso.get().load("https://openweathermap.org/img/w/${weatherForecast.weather.get(0).icon}.png").into(imgWeather)
            txtDate.text = StringBuilder("${Common.convertUnixToDate(weatherForecast.dt)}")
            txtDescription.text = StringBuilder(weatherForecast.weather.get(0).description)
            txtTemperature.text = StringBuilder("${weatherForecast.main.temp}°C")
        }
    }

    override fun getItemCount(): Int {
        return weatherForecastAdapter.size
    }


    interface OnItemClickCallback {
        fun onItemClicked(data: ListItem)
    }

    class RecyclerViewHolder(var binding: ItemWeatherForecastBinding) : RecyclerView.ViewHolder(binding.root)

    private val clickTag = "__click__"
    fun View.blockingClickListener(debounceTime: Long = 1200L, action: () -> Unit) {
        this.setOnClickListener(object : View.OnClickListener {
            private var lastClickTime: Long = 0
            override fun onClick(v: View) {
                val timeNow = SystemClock.elapsedRealtime()
                val elapsedTimeSinceLastClick = timeNow - lastClickTime
                Log.d(clickTag, """
                        DebounceTime: $debounceTime
                        Time Elapsed: $elapsedTimeSinceLastClick
                        Is within debounce time: ${elapsedTimeSinceLastClick < debounceTime}
                    """.trimIndent())

                if (elapsedTimeSinceLastClick < debounceTime) {
                    Log.d(clickTag, "Double click shielded")
                    return
                }
                else {
                    Log.d(clickTag, "Click happened")
                    action()
                }
                lastClickTime = SystemClock.elapsedRealtime()
            }
        })
    }

}