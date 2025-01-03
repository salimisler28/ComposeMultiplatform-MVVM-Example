package com.salimisler.cmpmvvm.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

expect object KMMDispatchers {
    fun io(): CoroutineDispatcher
}