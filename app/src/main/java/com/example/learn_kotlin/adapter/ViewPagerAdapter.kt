package com.example.learn_kotlin.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learn_kotlin.CityFragment
import com.example.learn_kotlin.ForecastFragment
import com.example.learn_kotlin.TodayWeatherFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TodayWeatherFragment()
            1 -> fragment = ForecastFragment()
            2 -> fragment = CityFragment()

        }
        return fragment as Fragment
    }

}