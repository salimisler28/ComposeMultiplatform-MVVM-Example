package com.salimisler.cmpmvvm.presentation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationDestination {
    @Serializable
    data object BottomNavScreen : NavigationDestination()
    @Serializable
    data class ProductDetail(val id: Int) : NavigationDestination()
}

sealed class NavigationEventType {
    data object NavigateUp : NavigationEventType()
    data class ToDestination(val navigationDestination: NavigationDestination) :
        NavigationEventType()
}

object Navigator {
    private val _navEvent = Channel<NavigationEventType>()
    val navEvent = _navEvent.receiveAsFlow()

    suspend fun navigateUp() {
        _navEvent.send(NavigationEventType.NavigateUp)
    }

    suspend fun toDestination(destination: NavigationDestination) {
        _navEvent.send(NavigationEventType.ToDestination(destination))
    }
}