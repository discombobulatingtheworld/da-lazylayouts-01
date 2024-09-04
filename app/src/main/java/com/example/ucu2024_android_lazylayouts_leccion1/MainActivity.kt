package com.example.ucu2024_android_lazylayouts_leccion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.ucu2024_android_lazylayouts_leccion1.ui.theme.alt.Ucu2024androidlazylayoutsleccion1Theme
import com.example.ucu2024_android_lazylayouts_leccion1.views.ChatView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ucu2024androidlazylayoutsleccion1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ChatView(innerPadding)
                }
            }
        }
    }
}