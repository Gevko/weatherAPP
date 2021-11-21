package com.example.myapplication.ui.cities.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.data.models.WeatherInfo
import com.example.myapplication.ui.adapters.CitiesAdapter
import kotlinx.android.synthetic.main.fragment_city_details.*
import kotlin.math.truncate


class CityDetailsFragment : Fragment() {

    private lateinit var weatherInfo: WeatherInfo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // this should be a constant
        weatherInfo = arguments?.get("data") as WeatherInfo

        return inflater.inflate(R.layout.fragment_city_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
    }

    private fun setupData() {

        // should use a resource with values for this suffix
        city_name_details_tv.text = weatherInfo.name
        temp_details_tv.text = "${truncate(weatherInfo.main?.temp!!-273.15)} Cº"
        min_temp_details_tv.text = "${truncate(weatherInfo.main?.temp_min!!-273.15)} Cº"
        max_temp_details_tv.text = "${truncate(weatherInfo.main?.temp_max!!-273.15)} Cº"
        wind_speed_details_tv.text = "Wind: ${weatherInfo.wind?.speed?.let { truncate(it).toString() }} m/s"
        pressure_details_tv.text = "Pressure: ${weatherInfo.main?.pressure?.let { truncate(it).toString() }} hPa"
        humidity_details_tv.text = "Humidity: ${weatherInfo.main?.humidity.toString()} %"

    }
}