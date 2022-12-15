package com.pikti.app_one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pikti.app_one.common.Common
import com.pikti.app_one.databinding.FragmentTodayWeatherBinding
import com.pikti.app_one.retrofit.IOpenWeatherMap
import com.pikti.app_one.retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class TodayWeatherFragment : Fragment() {

    private lateinit var binding: FragmentTodayWeatherBinding
    private lateinit var compositeDisposable: CompositeDisposable
    private lateinit var mService : IOpenWeatherMap
    private lateinit var retrofit : Retrofit


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        compositeDisposable.add(
            mService.getWeatherByLatLng(
                Common.current_location?.latitude.toString(),
                Common.current_location?.longitude.toString(),
                Common.APP_ID,
                "metric" )
            .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { weatherResult ->
                        binding.txtCityName.text = weatherResult.name
                        binding.txtGeoCoordinate.text = weatherResult.coord.toString()
                        binding.txtDescription.text = weatherResult.weather?.get(0)?.description ?: "N/A"
                        binding.txtTemperature.text = weatherResult.main?.temp.toString()
                        binding.txtDateTime.text = weatherResult.dt?.let { Common.convertUnixToDate(it)}
                        binding.txtHumidity.text = weatherResult.main?.humidity.toString()
                        binding.txtDateTime.text = weatherResult.dt?.let { Common.convertUnixToHour(it)}
                        binding.txtSunrise.text = weatherResult.sys?.sunrise?.let { Common.convertUnixToDate(it) }
                        binding.txtSunset.text = weatherResult.sys?.sunset?.let { Common.convertUnixToDate(it) }

                        binding.weatherPanel.visibility = View.VISIBLE
                        binding.loading.visibility = View.GONE

                    },
                    {
                        it -> it.printStackTrace()
                    }
                )

        )
    }


}