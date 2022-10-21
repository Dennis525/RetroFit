package com.example.retrofit.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.api.model.ProductItem
import com.example.retrofit.data.repository.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepo: ProductRepo
): ViewModel(){
    private val _state = MutableStateFlow(emptyList<ProductItem>())
    val state:StateFlow<List<ProductItem>>
     get() = _state

    init {
        viewModelScope.launch {
            val products = productRepo.getProduct()
            _state.value = products
        }
    }

}