package com.meadetechnologies.mviarchitectureexample.ui

import com.meadetechnologies.mviarchitectureexample.util.DataState

interface DataStateListener {

    fun onDataStateChange(dataState: DataState<*>?)
}