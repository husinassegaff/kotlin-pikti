package com.example.learn_kotlin.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learn_kotlin.ForecastFragment
import com.example.learn_kotlin.TodayWeatherFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TodayWeatherFragment()
            1 -> fragment = ForecastFragment()
        }
        return fragment as Fragment
    }

}