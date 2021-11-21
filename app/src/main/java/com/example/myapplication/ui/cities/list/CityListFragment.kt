package com.example.myapplication.ui.cities.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.models.EventObserver
import com.example.myapplication.ui.adapters.CitiesAdapter
import com.example.myapplication.ui.cities.CityViewModel
import com.example.myapplication.ui.cities.details.CityDetailsFragment
import kotlinx.android.synthetic.main.fragment_city_list.*

class CityListFragment : Fragment() {

    private val adapter: CitiesAdapter = CitiesAdapter()

    private lateinit var viewModel: CityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        viewModel = ViewModelProvider(requireActivity()).get(CityViewModel::class.java)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setupObservables()

        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureAdapter()
    }

    private fun configureAdapter() {
        adapter.onItemClick = { item ->
            viewModel.onCitySelected(item)
        }

        cities_list.adapter = adapter
    }

    private fun setupObservables() {
        viewModel.getCitiesWeatherInfo(null, null)

        viewModel.weatherInfoList.observe(viewLifecycleOwner) {
            adapter.items = it
        }

        viewModel.goToWeatherDetails.observe(viewLifecycleOwner, EventObserver  {
                val bundle = Bundle()
                bundle.putSerializable("data", it)

                requireActivity().supportFragmentManager.commit {
                    add(R.id.main_constraint_layout, CityDetailsFragment::class.java, bundle)
                    addToBackStack(null)
                }
        })
    }

}