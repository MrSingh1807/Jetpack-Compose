
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat
import androidx.navigation.NavController
import com.example.jetpackcompose.R

@Composable
fun Home(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)
    ) {
        TextField(
            value = " ",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 10.dp),
            shape = RoundedCornerShape(5.dp),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search , contentDescription = " " )
            } )
        Text(text = "My Images",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold)
        LazyColumn(
            modifier = Modifier.padding(top = 10.dp)
        ){
            var i = 0
            items((1..5).toList()){
                TaskCard("Items - ${++i}",navController, R.drawable.ic_items)
            }
        }

    }
}

@Composable
fun TaskCard(task: String, navController: NavController?,id: Int){
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor =  Color.LightGray ,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 8.dp)
            .clickable {
                navController?.navigate("Task")
            }
    ) {
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.padding(end = 32.dp).size(32.dp),
                painter = painterResource(id),
                contentDescription = "" )
            Text(text = task,
           fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome(){
   Home()
}