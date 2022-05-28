package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CoilImage()
                }
            }
        }
    }
}

@Composable
fun CoilImage(){
    Box(modifier = Modifier
        .height(200.dp)
        .width(200.dp), contentAlignment = Alignment. Center){
        val painter = rememberImagePainter(data = "https://avatars.githubusercontent.com/u/28947735?v=4",
        builder = {
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_background)
            crossfade(1000)
            transformations(
                //CircleCropTransformation(),
                RoundedCornersTransformation(50f)
            )
        })
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo Image")
        //if (painterState is AsyncImagePainter.State.Loading){
           // CircularProgressIndicator()
        //}
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {

    }
}