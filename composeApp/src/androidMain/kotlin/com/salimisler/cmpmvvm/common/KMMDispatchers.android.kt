package com.salimisler.cmpmvvm.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual object KMMDispatchers {
    actual fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}