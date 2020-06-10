package com.meadetechnologies.mviarchitectureexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.meadetechnologies.mviarchitectureexample.ui.main.state.MainStateEvent
import com.meadetechnologies.mviarchitectureexample.ui.main.state.MainStateEvent.*
import com.meadetechnologies.mviarchitectureexample.ui.main.state.MainViewState
import com.meadetechnologies.mviarchitectureexample.util.AbsentLiveData

class MainViewModel: ViewModel() {

    private val _stateEvent: MutableLiveData<MainStateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<MainViewState> = MutableLiveData()

    val viewState: LiveData<MainViewState>
        get() = _viewState

    val dataState: LiveData<MainStateEvent> = Transformations
        .switchMap(_stateEvent){ stateEvent ->
            stateEvent?.let {
                handleStateEvent(it)
            }
        }

    fun handleStateEvent(stateEvent: MainStateEvent) : LiveData<MainStateEvent>{
        when(stateEvent){
            is GetBlogPostsEvent -> {
                return AbsentLiveData.create()
            }
            is GetUserEvent -> {
                return AbsentLiveData.create()
            }
            is None -> {
                return AbsentLiveData.create()
            }
        }
    }

}