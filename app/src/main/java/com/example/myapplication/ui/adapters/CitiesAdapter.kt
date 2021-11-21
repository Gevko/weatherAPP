package com.example.myapplication.ui.adapters

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.models.WeatherInfo
import com.example.myapplication.interfaces.IAdapter
import kotlinx.android.synthetic.main.fragment_city_item.view.*
import kotlin.math.truncate


class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>(),
    IAdapter<WeatherInfo> {

    override var items: List<WeatherInfo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged() // this should be a DiffUtils in order to improve performance
        }

    override var onItemClick: ((WeatherInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val inflatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_city_item, parent, false)

        return CitiesViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(weatherInfo: WeatherInfo) {

            itemView.city_name_tv.text = weatherInfo.name

            itemView.temperature_tv.text = if(weatherInfo.main?.temp != null) {
                //K - 273.15
                truncate(weatherInfo.main?.temp!! -273.15).toString() + " Cº"
            } else {
                "N/D"
            }

            itemView.weather_iv.visibility = if(weatherInfo.rain != null) {
                View.VISIBLE
            } else {
                View.INVISIBLE
            }

            itemView.description_tv.text = weatherInfo.weather[0].description

            itemView.card_view.setOnClickListener {
                onItemClick?.invoke(weatherInfo)
            }
        }


    }
}