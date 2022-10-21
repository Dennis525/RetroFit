package com.example.retrofit.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.retrofit.data.api.model.Product
import com.example.retrofit.data.api.model.ProductItem
import java.lang.reflect.Modifier

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()
    
    LazyColumn{
        if (state.isEmpty()){
            item {
                CircularProgressIndicator(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }
        items(state){productItem: ProductItem ->
            ProductImageCard(productItem = productItem)
        }
    }
}
@Composable
fun ProductImageCard(productItem: ProductItem) {
    val imagePainter = rememberAsyncImagePainter(model = productItem.image)

    Card(
        shape = MaterialTheme.shapes.medium , modifier = androidx.compose.ui.Modifier.padding(16.dp)
    ) {
        Box{
            Image(painter = imagePainter,
                contentDescription = null,
                modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillBounds
            )
            
            androidx.compose.material.Surface(
                color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = androidx.compose.ui.Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface

            ) {
                Column(modifier = androidx.compose.ui.Modifier
                    .fillMaxWidth()
                    .padding(4.dp)) {
                    Text(text = "Product: ${productItem.title}")
                    Text(text = "Price: ${productItem.price}")
                    Text(text = "Category: ${productItem.category}")
                    Text(text = "${productItem.rating}")
                }

            }
        }
    }
}