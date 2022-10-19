package com.freelosophy.jetpackcomposereto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freelosophy.jetpackcomposereto1.ui.theme.CustomBackground
import com.freelosophy.jetpackcomposereto1.ui.theme.JetpackComposeReto1Theme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeReto1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = CustomBackground) {
                    RetoAris("Aris")
                }
            }
        }
    }
}

@Composable
fun RetoAris(name: String) {
    var messages by remember { mutableStateOf(1) }
    var messageClick by rememberSaveable { mutableStateOf(false)}
    var retweets by remember { mutableStateOf(1) }
    var retweetClick by rememberSaveable { mutableStateOf(false)}
    var likes by remember { mutableStateOf(1)}
    var likeClick by rememberSaveable { mutableStateOf(false)}

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CustomBackground)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Column(modifier = Modifier
                .weight(0.2f)
            ) {
                Image(
                    painterResource(R.drawable.profile),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                )
            }
            Column(
                modifier = Modifier
                    .weight(0.8f)
                    .padding(8.dp)
            ) {
                Row {
                    Text(
                        text = "$name",
                        color = Color.White
                    )
                    Text(
                        text = "@AristiDevs",
                        color = Color.DarkGray,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Text(
                        text = "4h",
                        color = Color.DarkGray
                    )
                    Column(
                       horizontalAlignment = Alignment.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_dots),
                            contentDescription = "",
                            tint = Color.White,
                        )
                    }
                }
                Row{
                    Text(text= "Descricion larga sdfffaf sobre dwd texto Descricion larga sobre dwd texto " +
                            "Descricion larga sobre dwd texto Descricion larga sobre dwd texto Descricion larga sobre dwd texto",
                    color = Color.White)
                }
                Row {
                   Image(
                       painter = painterResource(R.drawable.profile),
                       contentDescription = null,
                       modifier = Modifier
                           .height(225.dp)
                           .padding(vertical = 12.dp)
                           .clip(RoundedCornerShape(25.dp)),
                       contentScale = ContentScale.FillWidth
                   )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                if(messageClick) painterResource(R.drawable.ic_chat_filled)
                                else painterResource(R.drawable.ic_chat),
                                contentDescription = "",
                                tint =  Color.DarkGray,
                                modifier = Modifier
                                    .clickable {
                                        if (!messageClick) {
                                            messages += 1
                                            messageClick = true
                                        } else {
                                            messages -= 1
                                            messageClick = false
                                        }

                                    }
                            )
                            Text(
                                text = messages.toString(),
                                color = Color.DarkGray,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(horizontal = 3.dp)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painterResource(R.drawable.ic_rt),
                                contentDescription = "",
                                tint = if (retweetClick) Color.Green else Color.DarkGray,
                                modifier = Modifier
                                    .clickable {
                                        if (!retweetClick) {
                                            retweets += 1
                                            retweetClick = true
                                        } else {
                                            retweets -= 1
                                            retweetClick = false
                                        }

                                    }
                            )
                            Text(
                                text = retweets.toString(),
                                color = Color.DarkGray,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(horizontal = 3.dp)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                if (likeClick) painterResource(R.drawable.ic_like_filled) else painterResource(R.drawable.ic_like),
                                contentDescription = "",
                                tint = if (likeClick) Color.Red else Color.DarkGray,
                                modifier = Modifier
                                    .clickable {
                                        if (!likeClick) {
                                            likes += 1
                                            likeClick = true
                                        } else {
                                            likes -= 1
                                            likeClick = false
                                        }

                                    }
                            )
                            Text(
                                text = likes.toString(),
                                color = Color.DarkGray,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(horizontal = 3.dp)
                            )
                        }
                    }
                }
            }
        }
        Divider(
            modifier = Modifier
                .background(Color.LightGray)
                .height(1.dp)
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 8.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeReto1Theme {
        RetoAris("Aris")
    }
}