package com.example.routetask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidtask.api.models.Product
import com.example.androidtask.api.models.ProductsResponse
import com.example.routetask.api.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel: ViewModel() {
    var productLiveData= MutableLiveData<List<Product>>()
    fun getProduct(){
        ApiManager.getApis().getProducts().
        enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(p0: Call<ProductsResponse>, p1: Response<ProductsResponse>) {
                productLiveData.value=p1.body()?.products
            }

            override fun onFailure(p0: Call<ProductsResponse>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}