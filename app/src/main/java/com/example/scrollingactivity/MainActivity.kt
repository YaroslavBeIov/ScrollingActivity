package com.example.scrollingactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrollingactivity.ui.theme.ScrollingActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollingActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.myasnik),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Тихо лужи покрывает лёд, помнишь, мы с тобою\n" +
                            "Целовались ночи напролёт под шум прибоя?\n" +
                            "Это лето не вернуть уже, я знаю\n" +
                            "Но когда печаль в моей душе, я вспоминаю…" +
                            "Яхта, парус, в этом мире только мы одни\n" +
                            "Ялта, август, и мы с тобою влюблены\n" +
                            "Яхта, парус, в этом мире только мы одни\n" +
                            "Ялта, август, и мы с тобою влюблены\n\n" +
                            "Но расстаться нам с тобой пришлось, кончилась путёвка\n" +
                            "И вагон плацкартный меня нёс в Новую Каховку\n" +
                            "Не забуду ночи при луне и твою улыбку\n" +
                            "Ты открытку подарила мне, а на той открытке…" +
                            "Яхта, парус, в этом мире только мы одни\n" +
                            "Ялта, август, и мы с тобою влюблены\n" +
                            "Яхта, парус, в этом мире только мы одни\n" +
                            "Ялта, август, и мы с тобою влюблены.\n\n")
                    withStyle(style = androidx.compose.ui.text.SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Жирный текст.\n")
                    }
                    withStyle(style = androidx.compose.ui.text.SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Это подчеркнутая строка текста.\n")
                    }
                },
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    ScrollingActivityTheme {
        MainContent()
    }
}
