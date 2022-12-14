package com.example.learn_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learn_kotlin.adapter.ViewPagerAdapter
import com.example.learn_kotlin.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager(){
        val viewPagerAdapter = ViewPagerAdapter(this)
        val viewPager = binding.viewPager
        viewPager.adapter = viewPagerAdapter
        val tabs = binding.tabs
    }

    private fun buildLocationRequest() {
        locationRequest = LocationRequest.create().apply {
            interval = 5000
            fastestInterval = 3000
            smallestDisplacement = 10f
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }

        //non deprecated equivalent from code above

    }
}