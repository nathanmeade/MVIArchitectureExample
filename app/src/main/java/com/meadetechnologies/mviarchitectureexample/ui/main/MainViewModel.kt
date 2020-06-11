package com.meadetechnologies.mviarchitectureexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.meadetechnologies.mviarchitectureexample.model.BlogPost
import com.meadetechnologies.mviarchitectureexample.model.User
import com.meadetechnologies.mviarchitectureexample.repository.Repository
import com.meadetechnologies.mviarchitectureexample.ui.main.state.MainStateEvent
import com.meadetechnologies.mviarchitectureexample.ui.main.state.MainStateEvent.*
import com.meadetechnologies.mviarchitectureexample.ui.main.state.MainViewState
import com.meadetechnologies.mviarchitectureexample.util.AbsentLiveData

class MainViewModel: ViewModel() {

    private val _stateEvent: MutableLiveData<MainStateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<MainViewState> = MutableLiveData()

    val viewState: LiveData<MainViewState>
        get() = _viewState

    val dataState: LiveData<MainViewState> = Transformations
        .switchMap(_stateEvent){ stateEvent ->
            stateEvent?.let {
                handleStateEvent(it)
            }
        }

    fun handleStateEvent(stateEvent: MainStateEvent) : LiveData<MainViewState>{
        when(stateEvent){
            is GetBlogPostsEvent -> {
                return Repository.getBlogPosts()
            }
            is GetUserEvent -> {
                return Repository.getUser(stateEvent.userId)
            }
            is None -> {
                return AbsentLiveData.create()
            }
        }
    }

    fun setBlogListData(blogPosts: List<BlogPost>){
        val update = getCurrentViewStateOrNew()
        update.blogPosts = blogPosts
        _viewState.value = update
    }

    fun setUser(user: User){
        val update = getCurrentViewStateOrNew()
        update.user = user
        _viewState.value = update
    }

    fun getCurrentViewStateOrNew(): MainViewState{
        val value = viewState.value?.let {
            it
        }?: MainViewState()
        return value
    }

    fun setStateEvent(event: MainStateEvent){
        _stateEvent.value = event
    }
}