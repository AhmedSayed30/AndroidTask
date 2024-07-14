package com.example.routetask.api

import com.example.androidtask.api.models.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET

interface Webservices {
    @GET("products")
    fun getProducts(): Call<ProductsResponse>
}