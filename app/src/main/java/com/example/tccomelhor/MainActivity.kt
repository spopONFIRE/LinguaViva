package com.example.tccomelhor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tccomelhor.ui.theme.TccomelhorTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TccomelhorTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "Inicio"){
                    composable("inicio") { Inicio(navController)}
                    composable("login") { Login(navController) }
                    composable("registro") { Registro(navController) }
                }
            }
        }
    }
}
