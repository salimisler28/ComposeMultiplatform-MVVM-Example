package com.salimisler.cmpmvvm.data.dtos

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val rate: Double,
    val count: Int
)