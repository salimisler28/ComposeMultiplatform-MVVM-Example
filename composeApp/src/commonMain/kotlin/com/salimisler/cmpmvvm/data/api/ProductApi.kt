package com.salimisler.cmpmvvm.data.api

import com.salimisler.cmpmvvm.common.KMMDispatchers
import com.salimisler.cmpmvvm.data.dtos.Product
import com.salimisler.cmpmvvm.data.makeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.withContext

class ProductApi constructor(
    private val httpClient: HttpClient
) {
    suspend fun products(): Result<List<Product>> {
        return withContext(KMMDispatchers.io()) {
            makeCall {
                httpClient.get("https://fakestoreapi.com/products")
            }
        }
    }

    suspend fun productDetail(id: Int): Result<Product> {
        return withContext(KMMDispatchers.io()) {
            makeCall {
                httpClient.get("https://fakestoreapi.com/products/${id}")
            }
        }
    }

    suspend fun categories(): Result<List<String>> {
        return withContext(KMMDispatchers.io()) {
            makeCall {
                httpClient.get("https://fakestoreapi.com/products/categories")
            }
        }
    }

    suspend fun productsByCategory(category: String): Result<List<Product>> {
        return withContext(KMMDispatchers.io()) {
            makeCall {
                httpClient.get("https://fakestoreapi.com/products/${category}")
            }
        }
    }
}