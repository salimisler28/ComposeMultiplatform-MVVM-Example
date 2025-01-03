package com.salimisler.cmpmvvm

import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi

actual class GoogleAuthProvider {
    @OptIn(ExperimentalForeignApi::class)
    suspend fun x() {
        GIDSignIn.sharedInstance.signOut()
    }
}