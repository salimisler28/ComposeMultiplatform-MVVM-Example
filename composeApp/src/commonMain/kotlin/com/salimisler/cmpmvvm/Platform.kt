package com.salimisler.cmpmvvm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
expect class GoogleAuthProvider