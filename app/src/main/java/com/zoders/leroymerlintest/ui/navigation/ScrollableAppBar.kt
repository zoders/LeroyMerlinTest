package com.zoders.leroymerlintest.ui.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zoders.leroymerlintest.ui.components.CategoryItem
import com.zoders.leroymerlintest.data.getCategoriesList
import com.zoders.leroymerlintest.R

@Composable
fun ScrollableAppBar(
    scrollUpState: State<Boolean?>
) {
    val position by animateFloatAsState(if (scrollUpState.value == true) -250f else 0f)
    Surface(modifier = Modifier.graphicsLayer { translationY = (position) }, elevation = 8.dp) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color.White),
            ) {
                LazyRow(verticalAlignment = Alignment.CenterVertically) {
                    items(getCategoriesList()) { item ->
                        CategoryItem(category = item, modifier = Modifier.padding(5.dp))
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .background(color = Color.White)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.sort),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 5.dp)
                        )
                        Text(text = "Цена по возрастанию", color = Color.Black)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.filtres),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 5.dp)
                        )
                        Text(text = "Фильтры", color = Color.Black)
                    }
                }
            }
        }

    }
}