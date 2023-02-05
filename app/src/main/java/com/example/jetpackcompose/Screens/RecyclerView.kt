package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainData(){
    // How you can update your Jetpack Compose UI whenever state of your application is changed
    val user = User(
        1, "Mr Singh")
    val users = remember {
        mutableStateListOf(user)
    }
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        UserList(users = users)
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                users.add(User( 1, "Mr Singh"))
            }) {
            Text(text = "Add More")
        }
    }
}
@Composable
fun UserList(users: List<User>) {
    LazyColumn{  // Recycler View
        items(users){
            UserCard()
        }
    }
}

@Composable
fun UserCard() {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(6.dp)
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
fun PreviewMainData(){
    Surface(modifier = Modifier.fillMaxSize()) {
        MainData()
    }
}