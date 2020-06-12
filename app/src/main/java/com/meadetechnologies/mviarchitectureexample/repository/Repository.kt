package com.meadetechnologies.mviarchitectureexample.repository

import androidx.lifecycle.LiveData
import com.meadetechnologies.mviarchitectureexample.api.MyRetrofitBuilder
import com.meadetechnologies.mviarchitectureexample.model.BlogPost
import com.meadetechnologies.mviarchitectureexample.model.User
import com.meadetechnologies.mviarchitectureexample.ui.main.state.MainViewState
import com.meadetechnologies.mviarchitectureexample.util.ApiSuccessResponse
import com.meadetechnologies.mviarchitectureexample.util.DataState
import com.meadetechnologies.mviarchitectureexample.util.GenericApiResponse

object Repository {

    fun getBlogPosts(): LiveData<DataState<MainViewState>>{
        return object: NetworkBoundResource<List<BlogPost>, MainViewState>(){
            override fun handleApiSuccessResponse(response: ApiSuccessResponse<List<BlogPost>>) {
                result.value = DataState.data(
                    data = MainViewState(
                        blogPosts = response.body
                    )
                )
            }

            override fun createCall(): LiveData<GenericApiResponse<List<BlogPost>>> {
                return MyRetrofitBuilder.apiService.getBlogPosts()
            }

        }.asLiveData()
    }

    fun getUser(userId: String): LiveData<DataState<MainViewState>>{
        return object: NetworkBoundResource<User, MainViewState>(){
            override fun handleApiSuccessResponse(response: ApiSuccessResponse<User>) {
                result.value = DataState.data(
                    data = MainViewState(
                        user = response.body
                    )
                )
            }

            override fun createCall(): LiveData<GenericApiResponse<User>> {
                return MyRetrofitBuilder.apiService.getUser(userId)
            }

        }.asLiveData()
    }
}