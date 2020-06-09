package com.meadetechnologies.mviarchitectureexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meadetechnologies.mviarchitectureexample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMainFragment()
    }

    fun showMainFragment(){
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                MainFragment(), "MainFragment")
            .commit()
    }
}
