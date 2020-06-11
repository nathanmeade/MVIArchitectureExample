package com.meadetechnologies.mviarchitectureexample.util

data class DataState<T>(
    var message: String? = null,
    var loading: Boolean = false,
    var data: T? = null
){
    companion object{

        fun <T> error(
            message: String
        ): DataState<T>{
            return DataState(
                message = message,
                loading = false,
                data = null
            )
        }

        fun <T> loading(
            isLoading: Boolean
        ): DataState<T>{
            return DataState(
                message = null,
                loading = true,
                data = null
            )
        }

        fun <T> data(
            message: String? = null,
            data: T? = null
        ): DataState<T>{
            return DataState(
                message = message,
                loading = false,
                data = data
            )
        }
    }

    override fun toString(): String {
        return "DataState(message=$message, loading=$loading, data=$data)"
    }


}