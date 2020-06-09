package com.meadetechnologies.mviarchitectureexample.ui.main.state

import com.meadetechnologies.mviarchitectureexample.model.BlogPost
import com.meadetechnologies.mviarchitectureexample.model.User

data class MainViewState(

    var blogPosts: List<BlogPost>? = null,
    var user: User? = null
)