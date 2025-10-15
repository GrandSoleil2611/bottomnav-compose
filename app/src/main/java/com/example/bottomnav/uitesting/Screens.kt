package com.example.bottomnav.uitesting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

object Screens {
    @Composable
    fun Home() {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Home Screen")
        }
    }

    @Composable
    fun Search() {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Search Screen")
        }
    }

    @Composable
    fun Profile() {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Profile Screen")
        }
    }

    @Composable
    fun Settings() {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Settings Screen")
        }
    }
}