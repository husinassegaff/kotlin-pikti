package com.pikti.app_one

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.location.*
import com.google.android.gms.location.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.pikti.app_one.adapter.ViewPagerAdapter
import com.pikti.app_one.common.Common
import com.pikti.app_one.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewPager: ViewPager2
    private lateinit var tabs: TabLayout
    private lateinit var coordinatorLayout: CoordinatorLayout

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coordinatorLayout = binding.rootView

        Dexter.withContext(this)
            .withPermissions(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    if (report!!.areAllPermissionsGranted()) {
                        buildLocationCallback()
                        buildLocationRequest()

                        if(ActivityCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                            ActivityCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            return
                        }

                        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this@MainActivity)
                        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    //make snackbar "permission denied"
                    Snackbar.make(coordinatorLayout, "Permission Denied", Snackbar.LENGTH_LONG)
                        .show()
                }
            }).onSameThread().check()
    }

    private fun setupViewPager(viewPager: ViewPager2){
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
    }

    private fun buildLocationRequest() {
        locationRequest = LocationRequest.create().apply{
            interval = 5000
            fastestInterval = 3000
            smallestDisplacement = 10f
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                super.onLocationResult(p0)
                val location = p0.lastLocation

                viewPager = binding.viewPager
                tabs = binding.tabs

                setupViewPager(viewPager)
                TabLayoutMediator(tabs, viewPager) { tab, position ->
                    tab.text = "TODAY"
                }.attach()

                location?.let {
                    Common.current_location = it
                }
            }
        }
    }
}