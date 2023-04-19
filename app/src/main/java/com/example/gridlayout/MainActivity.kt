package com.example.gridlayout


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.gridlayout.ui.theme.GridLayoutTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items=(1..100).map {
            ListItem(
                height = Random.nextInt(100,300).dp,
                color = Color(
                    Random.nextLong(0xFFFFFFF)
                ).copy(alpha = 1f)
            )
        }
        setContent {
            GridLayoutTheme {
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                                contentPadding = PaddingValues(16.dp),
                                modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(items){item ->
                        RandomColorBox(item = item)
                    }
                }
            }
        }
    }
}
data class ListItem(
    val height: Dp,
    val color: androidx.compose.ui.graphics.Color
)
@Composable
fun RandomColorBox(item: ListItem){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(item.height)
        .clip(RoundedCornerShape(16.dp))
        .background(item.color)
    ) {
    }
}



