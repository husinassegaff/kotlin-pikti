package com.example.learn_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learn_kotlin.common.Common
import com.example.learn_kotlin.databinding.FragmentTodayWeatherBinding
import com.example.learn_kotlin.retrofit.IOpenWeatherMap
import com.example.learn_kotlin.retrofit.RetrofitClient
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class TodayWeatherFragment : Fragment() {

    private lateinit var binding: FragmentTodayWeatherBinding
    private lateinit var compositeDisposable: CompositeDisposable
    private lateinit var mService: IOpenWeatherMap
    private lateinit var retrofit: Retrofit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodayWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        compositeDisposable = CompositeDisposable()
        retrofit = RetrofitClient.loadData()
        mService = retrofit.create(IOpenWeatherMap::class.java)

        getWeatherInformation()
    }

    private fun getWeatherInformation() {
        compositeDisposable.add(mService.getWeatherByLatLng(Common.current_location?.latitude.toString(), Common.current_location?.longitude.toString(), Common.APP_ID, "metric")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    Picasso.get().load("https://openweathermap.org/img/w/${result.weather?.get(0)?.icon}.png").into(binding.imgWeather)

                    binding.cityName.text = result.name
                    binding.txtGeoCoordinate.text = StringBuilder("[${result.coord?.lat} , ${result.coord?.lon}]")
                    binding.txtDescription.text = StringBuilder("Weather in ${result.weather?.get(0)?.description}")
                    binding.txtTemperature.text = StringBuilder("${result.main?.temp}°C")
                    binding.txtPressure.text = StringBuilder("${result.main?.pressure} hpa")
                    binding.txtDateTime.text = result.dt?.let { Common.convertUnixToDate(it) }
                    binding.txtHumidity.text = StringBuilder("${result.main?.humidity}%")
                    binding.txtSunrise.text = result.sys?.sunrise?.let { Common.convertUnixToDate(it) }
                    binding.txtSunset.text = result.sys?.sunset?.let { Common.convertUnixToDate(it) }
                    binding.txtWind.text = StringBuilder("Speed: ${result.wind?.speed} deg: ${result.wind?.deg}")

                    binding.weatherPanel.visibility = View.VISIBLE
                    binding.loading.visibility = View.GONE
                },
                { t ->
                    t.printStackTrace()
                }
            )
        )
    }
}