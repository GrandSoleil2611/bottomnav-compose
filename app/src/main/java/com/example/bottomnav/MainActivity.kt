package com.example.bottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bottomnav.uitesting.Screens
import compose.ui.bottomnav.model.NavItem
import compose.ui.bottomnav.ui.ComposableBottomNav

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                var selectedId by remember { mutableStateOf("home") }

                val items = listOf(
                    NavItem(id = "home", label = "Home", icon = Icons.Default.Home),
                    NavItem(
                        id = "search",
                        label = "Search",
                        icon = Icons.Default.Search,
                        badgeCount = 5
                    ),
                    NavItem(id = "profile", label = "Profile", icon = Icons.Default.Person),
                    NavItem(id = "settings", label = "Settings", icon = Icons.Default.Settings)
                )

                Box(modifier = Modifier.fillMaxSize()) {
                    // Host controls what to display based on selectedId
                    when (selectedId) {
                        "home" -> Screens.Home()
                        "search" -> Screens.Search()
                        "profile" -> Screens.Profile()
                        "settings" -> Screens.Settings()
                        else -> Screens.Home()
                    }

                    ComposableBottomNav(
                        items = items,
                        selectedId = selectedId,
                        onItemSelected = { id ->
                            // Host updates selection state and performs navigation logic
                            selectedId = id
                        },
                        modifier = Modifier.align(androidx.compose.ui.Alignment.BottomCenter)
                    )
                }
            }
        }
    }
}
