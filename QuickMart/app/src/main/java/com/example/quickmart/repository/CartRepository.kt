package com.example.quickmart.repository

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quickmart.model.CartItem

object CartRepository {
    private val cartItems: MutableMap<String, CartItem> = mutableMapOf()

    fun addItem(cartItem: CartItem) {
        val existingItem = cartItems[cartItem.productName]
        if (existingItem != null) {
            existingItem.quantity += cartItem.quantity
        } else {
            cartItems[cartItem.productName] = cartItem
        }
    }

    fun updateItem(productName: String, quantity: Double) {
        val itemToUpdate = cartItems[productName]
        itemToUpdate?.quantity = quantity
    }

    fun removeItem(productName: String) {
        cartItems.remove(productName)
    }

    fun getCartItems(): List<CartItem> {
        return cartItems.values.toList()
    }

    fun getCartTotal(): Double {
        return cartItems.values.sumByDouble { it.calculateTotalPrice() }
    }
    fun clearCart() {
        cartItems.clear()
    }
}

@Composable
fun CartScreen(navController: NavHostController) {
    val context = LocalContext.current
    val cartItems by remember { mutableStateOf(CartRepository.getCartItems()) }
    var searchQuery by remember { mutableStateOf("") }
    var total = CartRepository.getCartTotal()

    val Purple80 = Color(0xFF81A35A)
    val PurpleGrey80 = Color(0xFF465A2E)
    val Pink80 = Color(0xFF557E25)

    val Purple40 = Color(0xFF4D5742)
    val PurpleGrey40 = Color(0xFF8BC34A)
    val Pink40 = Color(0xFF2E4D0A)

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "MyCart") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            backgroundColor = PurpleGrey40
        )

        LazyColumn {
            items(cartItems) { cartItem ->
                CartItemRow(cartItem, context) { newQuantity ->
                    // Update the quantity for the specific item
                    CartRepository.updateItem(cartItem.productName, newQuantity)
                    // Calculate the new total price
                    val newTotal = CartRepository.getCartTotal()
                    // Update the total price
                    total = newTotal
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f)) // Add Spacer to push BottomAppBar and Button to the bottom

        // Display the updated total price
        Text(
            text = "Total Price: ${CartRepository.getCartTotal()}",
            modifier = Modifier.padding(16.dp)
        )

        // Add the "Checkout" button
        Button(
            onClick = {
                // Perform the checkout action here
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Pink80, contentColor = Color.White)

        ) {
            Text(text = "Checkout")
        }

        // Add the BottomAppBar at the very bottom
        BottomAppBar(
            backgroundColor = PurpleGrey40,
            contentColor = Color.White,
            elevation = 4.dp,
            cutoutShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                IconButton(
                    onClick = {
                        // Handle cart icon click
                    },
                    modifier = Modifier.weight(1f)
                )
                {
                    Icon(Icons.Default.ShoppingCart, contentDescription = "Cart Icon")
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(
                    onClick = { navController.navigate("productList") },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home"
                    )
                }
            }
        }
    }
}

@SuppressLint("AutoboxingStateCreation")
@Composable
fun CartItemRow(cartItem: CartItem, context: Context, onQuantityChanged: (Double) -> Unit) {
    val quantityState = remember { mutableStateOf(cartItem.quantity) }
    val Purple80 = Color(0xFF81A35A)
    val PurpleGrey80 = Color(0xFF465A2E)
    val Pink80 = Color(0xFF557E25)

    val Purple40 = Color(0xFF4D5742)
    val PurpleGrey40 = Color(0xFF8BC34A)
    val Pink40 = Color(0xFF2E4D0A)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val imageId = context.resources.getIdentifier(
                cartItem.productImage, "drawable", context.packageName
            )

            if (imageId != 0) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
            }
            val Purple80 = Color(0xFF81A35A)
            val PurpleGrey80 = Color(0xFF465A2E)
            val Pink80 = Color(0xFF557E25)

            val Purple40 = Color(0xFF4D5742)
            val PurpleGrey40 = Color(0xFF8BC34A)
            val Pink40 = Color(0xFF2E4D0A)


            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = cartItem.productName, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Price: $${cartItem.price * quantityState.value} ")
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            if (quantityState.value > 0) {
                                quantityState.value--
                              if ( quantityState.value ==0.0)  CartRepository.removeItem(cartItem.productName)

                            }
                            onQuantityChanged(quantityState.value) // Notify the parent about the quantity change
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Purple40, contentColor = Color.White)

                        ) {
                        Text(text = "-")
                    }

                    Text(text = quantityState.value.toString())

                    Button(
                        onClick = {
                            quantityState.value++
                            onQuantityChanged(quantityState.value) // Notify the parent about the quantity change
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Purple40, contentColor = Color.White)

                    ) {
                        Text(text = "+")
                    }

                    IconButton(
                        onClick = {
                            // Notify the parent to remove the item from the cart
                            onQuantityChanged(0.0)
                            CartRepository.removeItem(cartItem.productName)
                        },
                    ) {
                        Icon(Icons.Default.Clear, contentDescription = "")
                    }
                }
            }
        }
    }
}
