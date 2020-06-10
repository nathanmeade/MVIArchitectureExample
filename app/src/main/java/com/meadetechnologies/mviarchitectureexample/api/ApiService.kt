package com.meadetechnologies.mviarchitectureexample.api

import com.meadetechnologies.mviarchitectureexample.model.BlogPost
import com.meadetechnologies.mviarchitectureexample.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("placeholder/blogs")
    fun getBlogPosts(): List<BlogPost>

    @GET("placeholder/user/{userId}")
    fun getUser(
        @Path("userId") userId: String
    ): User
}