package com.example.ktorsampleapp.utils

/**
 * Created by Taha Ben Ashur (https://github.com/tahaak67) on 08,Feb,2023
 */

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}