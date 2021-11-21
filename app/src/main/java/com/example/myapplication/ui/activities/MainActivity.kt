package com.example.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.myapplication.R
import com.example.myapplication.ui.cities.list.CityListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            add<CityListFragment>(R.id.main_constraint_layout)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}