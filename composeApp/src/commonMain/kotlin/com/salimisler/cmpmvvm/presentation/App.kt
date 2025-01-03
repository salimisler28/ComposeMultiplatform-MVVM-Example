package com.salimisler.cmpmvvm.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.salimisler.cmpmvvm.presentation.screens.bottomnav.BottomNavComponent
import com.salimisler.cmpmvvm.presentation.screens.productdetail.ProductDetailComponent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    LaunchedEffect(Unit) {
        Navigator.navEvent
            .onEach {
                when (it) {
                    NavigationEventType.NavigateUp -> {
                        navController.navigateUp()
                    }

                    is NavigationEventType.ToDestination -> {
                        navController.navigate(it.navigationDestination)
                    }
                }
            }
            .collect()
    }

    KoinApplication(application = { modules() }) {
        MaterialTheme {
            // To fix the dark color in navigation animation
            Surface {
                NavHost(
                    navController = navController,
                    startDestination = NavigationDestination.BottomNavScreen
                ) {
                    composable<NavigationDestination.BottomNavScreen> {
                        BottomNavComponent()
                    }

                    composable<NavigationDestination.ProductDetail> {
                        ProductDetailComponent()
                    }
                }
            }
        }
    }
}