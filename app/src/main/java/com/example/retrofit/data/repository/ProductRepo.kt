package com.example.retrofit.data.repository

import com.example.retrofit.data.api.ProductApi
import com.example.retrofit.data.api.model.Product
import com.example.retrofit.data.api.model.ProductItem
import javax.inject.Inject

class ProductRepo @Inject constructor(
    private val productApi: ProductApi
) {
    suspend fun getProduct():List<ProductItem>{
        return productApi.getProduct()
    }
}