package com.example.ayudamobile.composables

import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.ayudamobile.appFontFamily
import com.example.ayudamobile.ui.bluish
import com.example.ayudamobile.ui.red

@Preview(showBackground = true)
@Composable
fun topicsPreview() {
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        topics()


    }


}

@Composable
fun topics() {

    val textList = arrayListOf(
        "Subject one",
        "Subject two",
        "Subject three",
        "Subject four",
        "Subject two",
        "Subject three",
        "Subject four",
        "Subject two",
        "Subject three",
        "Subject four"
    )
    ScrollableColumn(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Pick a subject",
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, bottom = 4.dp),
            style = TextStyle(
                fontSize = 30.sp,
                color = red,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = appFontFamily
            )
        )
        textList.forEach {
            singleTopicWidget(it)
        }
        FloatingActionButton(
            onClick = {},
            backgroundColor = red,
            contentColor = Color.White,
            elevation = 4.dp
        ) {
            Icon(Icons.Filled.Add)
        }

    }

}

@Composable
fun singleTopicWidget(text: String) {
    Card(
        elevation = 2.dp,
        backgroundColor = Color.White,
        contentColor = bluish,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 4.dp, start = 8.dp, bottom = 4.dp, end = 8.dp).height(50.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }


    }


}