package com.vinodpatildev.jetpackcomposedemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinodpatildev.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            displaySnackbar()
        }
    }
}
@Composable
fun displaySnackbar(){
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            coroutineScope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is jetpack compose snackbar",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Long
                )
                when(snackBarResult){
                    SnackbarResult.ActionPerformed-> Log.i("mytag","action label clicked")
                    SnackbarResult.Dismissed->Log.i("mytag","dissmissed!!")
                }
            }
        }
        ){
            Text(text = "Display Snackbar")
        }
    }
}
@Composable
fun buttonDemo(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast.makeText(context,"Clicked On Butoon",Toast.LENGTH_LONG).show()
            }){
            Text(
                text = "Button"
            )
        }
        Button(
            onClick = {
                Toast.makeText(context,"Clicked On Butoon",Toast.LENGTH_LONG).show()
            },
            enabled = false
        ){
            Text(
                text = "Button"
            )
        }
        TextButton(
            onClick = {
                Toast.makeText(context,"Clicked On Butoon",Toast.LENGTH_LONG).show()
            }){
            Text(
                text = "Button"
            )
        }
        OutlinedButton(
            onClick = {
                Toast.makeText(context,"Clicked On Butoon",Toast.LENGTH_LONG).show()
            }){
            Text(
                text = "Button"
            )
        }
        IconButton(
            onClick = {
                Toast.makeText(context,"Clicked On Butoon",Toast.LENGTH_LONG).show()
            }){
            Icon(
                Icons.Filled.Refresh,
                contentDescription = "icon button",
                tint = Color.DarkGray,
                modifier = Modifier
                    .size(80.dp)
            )
        }
        Button(
            onClick = {
                Toast.makeText(context,"Clicked On Butoon",Toast.LENGTH_LONG).show()
            },
            contentPadding = PaddingValues(16.dp),
            border = BorderStroke(5.dp, Color.Black),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.White
            ),
        ){
            Text(
                text = "Button",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
        Button(
            onClick = {
                Toast.makeText(context,"Clicked On Butoon",Toast.LENGTH_LONG).show()
            },
            shape = CutCornerShape(10.dp),
            contentPadding = PaddingValues(16.dp),
            border = BorderStroke(5.dp, Color.Black),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.White
            ),
        ){
            Text(
                text = "Button",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}

@Composable
fun imageBoxExample(){
    Box(){
        Image(
            painter = painterResource(id = R.drawable.alex),
            contentDescription = "Nature"
        )
        Text(
            text = "Nature",
            style = MaterialTheme.typography.h6,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
        )
        Button(

            onClick = { },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.White,
                contentColor = Color.DarkGray
            ),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(4.dp)
                .border(2.dp, color = Color.DarkGray)
        ) {
            Text(
                text = "Submit",
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Composable
fun rowExample(){
    Row(
                modifier = Modifier
                    .background(color = Color.Magenta)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Greeting("Ram")
                Greeting("Atharva")
                Greeting("Sita")
            }
}

@Composable
fun boxAlignmentExample(){
    Box(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxSize()
            .border(2.dp, color = Color.Black)
    ){
        Text(
            text = "Top Start",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.TopStart)
        )
        Text(
            text = "Top Center",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.TopCenter)
        )
        Text(
            text = "Top End",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.TopEnd)
        )
        Text(
            text = "Center Start",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.CenterStart)
        )
        Text(
            text = "Center",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.Center)
        )
        Text(
            text = "Center End",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.CenterEnd)
        )
        Text(
            text = "Bottom Start",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.BottomStart)
        )
        Text(
            text = "Bottom Center",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.BottomCenter)
        )
        Text(
            text = "Center End",
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(2.dp)
                .align(Alignment.BottomEnd)
        )

    }
}

@Composable
fun boxExample(){
    Box(
        modifier = Modifier
            .background(color = Color.Red)
            .size(200.dp, 300.dp)
            .border(5.dp, color = Color.Blue)
    ){
        Box(
            modifier = Modifier
                .background(color = Color.Green)
                .size(150.dp, 200.dp)
                .border(5.dp, color = Color.Blue)
                .align(alignment = Alignment.Center)
        ){
            Text(
                text = "Vinod",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .size(100.dp, 150.dp)
                    .align(alignment = Alignment.Center)
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = name,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Green,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.LightGray)
            .border(3.dp, color = Color.Blue)
            .padding(5.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        Greeting("Vinod")
    }
}