package com.example.mobileapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobileapp1.ui.theme.MobileApp1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyList()
                }
            }
        }
    }
}

@Composable
fun MyList() {
    val browsers = listOf("chrome", "opera", "safari", "edge", "firefox")
    val browserIds = listOf(R.drawable.chrome, R.drawable.opera, R.drawable.safari, R.drawable.edge, R.drawable.firefox).shuffled()
    LazyColumn(modifier=Modifier.fillMaxSize()) {
        itemsIndexed(browsers){ i, name ->
            Row {
                Image(painterResource(id = browserIds[i]), name, modifier = Modifier.height(50.dp))
                Text(name, modifier = Modifier.padding(15.dp))
            }
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MobileApp1Theme {
        MyList()
    }
}