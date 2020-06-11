package com.meadetechnologies.mviarchitectureexample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.meadetechnologies.mviarchitectureexample.api.MyRetrofitBuilder
import com.meadetechnologies.mviarchitectureexample.ui.main.state.MainViewState
import com.meadetechnologies.mviarchitectureexample.util.ApiEmptyResponse
import com.meadetechnologies.mviarchitectureexample.util.ApiErrorResponse
import com.meadetechnologies.mviarchitectureexample.util.ApiSuccessResponse

object Repository {

    fun getBlogPosts(): LiveData<MainViewState>{
        return Transformations
            .switchMap(MyRetrofitBuilder.apiService.getBlogPosts()){ apiResponse ->
                object : LiveData<MainViewState>(){
                    override fun onActive() {
                        super.onActive()
                        when(apiResponse){

                            is ApiSuccessResponse -> {
                                value = MainViewState(blogPosts = apiResponse.body)
                            }

                            is ApiErrorResponse -> {
                                value = MainViewState()
                            }

                            is ApiEmptyResponse -> {
                                value = MainViewState()
                            }
                        }
                    }
                }
            }
    }

    fun getUser(userId: String): LiveData<MainViewState>{
        return Transformations
            .switchMap(MyRetrofitBuilder.apiService.getUser(userId)){ apiResponse ->
                object : LiveData<MainViewState>(){
                    override fun onActive() {
                        super.onActive()
                        when(apiResponse){

                            is ApiSuccessResponse -> {
                                value = MainViewState(user = apiResponse.body)
                            }

                            is ApiErrorResponse -> {
                                value = MainViewState()
                            }

                            is ApiEmptyResponse -> {
                                value = MainViewState()
                            }
                        }
                    }
                }
            }
    }
}