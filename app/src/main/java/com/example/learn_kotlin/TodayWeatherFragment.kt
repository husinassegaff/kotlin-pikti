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
            .subscribe() { weatherResult ->

                binding.cityName.text = weatherResult.name
                binding.txtDescription.text = StringBuilder("Weather in ${weatherResult.name}")
                binding.txtTemperature.text = StringBuilder(weatherResult.main?.temp.toString()).append("°C").toString()
                binding.txtDateTime.text = weatherResult.dt?.let { Common.convertUnixToDate(it) }
                binding.txtWind.text = StringBuilder(weatherResult.wind?.speed.toString()).append("km/h").toString()
                binding.txtPressure.text = StringBuilder("${weatherResult.main?.pressure} hpa").toString()
                binding.txtHumidity.text = StringBuilder("${weatherResult.main?.humidity} %").toString()
                binding.txtSunrise.text = weatherResult.sys?.sunrise?.let {
                    Common.convertUnixToHour(
                        it
                    )
                }
                binding.txtSunset.text = weatherResult.sys?.sunset?.let { Common.convertUnixToHour(it) }
                binding.txtGeoCoordinate.text = StringBuilder("[${weatherResult.coord?.lat}, ${weatherResult.coord?.lon}]").toString()
            })
    }




}