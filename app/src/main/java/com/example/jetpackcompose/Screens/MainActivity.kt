package com.example.jetpackcompose.Screens

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.jetpackcompose.MainContent
import com.example.jetpackcompose.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithXML()
        }
    }
}

@Composable
fun ComposeWithXML() {
    Column {
        AndroidView(
            factory = {
                View.inflate(it, R.layout.activity_main, null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            update = {view ->
                val name = view.findViewById<TextView>(R.id.nameTV)
                name.setOnClickListener {
                    Toast.makeText(view.context, "This is Singh",Toast.LENGTH_SHORT).show()
                }
            }
        )
       MainContent()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
       ComposeWithXML()
    }
}