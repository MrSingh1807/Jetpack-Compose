package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserList()
        }
    }
}

@Composable
fun UserList() {
 /*    ****** List View *****
   Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (i in 1..10) {
            UserCard()
        }
    }   */

    LazyColumn{         // Recycler View
        items((1..10).toList()  // Here pass your list
        ){
            UserCard()
        }
    }
}


@Composable
fun UserCard() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(5.dp)
                .border(1.dp, color = Color.Gray)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = " ",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 150.dp, height = 180.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = stringResource(id = R.string.dummyText),
                    modifier = Modifier.padding(start = 10.dp)
                )

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                ) {
                    Text(text = "View Profile")
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
        UserList()
    }
}
