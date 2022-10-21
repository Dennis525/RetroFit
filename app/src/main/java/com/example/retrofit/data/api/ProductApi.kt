package com.example.retrofit.data.api

import com.example.retrofit.data.api.model.Product
import com.example.retrofit.data.api.model.ProductItem
import retrofit2.http.GET

interface ProductApi {

    @GET(ApiConstant.END_POINT)
    suspend fun getProduct():List<ProductItem>
}