package com.meadetechnologies.mviarchitectureexample.api

import androidx.lifecycle.LiveData
import com.meadetechnologies.mviarchitectureexample.model.BlogPost
import com.meadetechnologies.mviarchitectureexample.model.User
import com.meadetechnologies.mviarchitectureexample.util.GenericApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("placeholder/blogs")
    fun getBlogPosts(): LiveData<GenericApiResponse<List<BlogPost>>>

    @GET("placeholder/user/{userId}")
    fun getUser(
        @Path("userId") userId: String
    ): LiveData<GenericApiResponse<User>>
}