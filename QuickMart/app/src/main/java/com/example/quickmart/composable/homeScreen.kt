package com.example.quickmart.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun hello(name:String){
    Text("hello")
}

@Preview
@Composable
fun preview(){
    hello(name="textView")
}