package com.example.quickmart

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickmart.repository.CartScreen
import com.example.quickmart.repository.ProductListScreen
import com.example.quickmart.repository.ProductRepository
import com.example.quickmart.ui.theme.QuickMartTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productRepository = ProductRepository
        productRepository.initProducts(applicationContext)
        
        setContent {
//
//            Scaffold(
//                topBar = {
//                androidx.compose.material.TopAppBar {
//                    Text(text = "MyApp")
//                }
//                }
//            ) {
//            }
            QuickMartTheme {




                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "productList") {
                        composable("productList") {
                            ProductListScreen(navController)
                        }
                        composable("cart") {
                            CartScreen(navController)
                        }
                    }
                // Use the ProductListScreen composable as the content of the activity
         //       ProductListScreen(navController)

            }


        }
    }
}
