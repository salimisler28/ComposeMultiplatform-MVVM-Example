package com.salimisler.cmpmvvm.data

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

suspend inline fun <reified T> makeCall(
    call: () -> HttpResponse
): Result<T> {
    return try {
        val response = call.invoke()
        return if (response.status.isSuccess()) {
            Result.success(response.body<T>())
        } else {
            Result.failure(Exception(response.status.toString()))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}