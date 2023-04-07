package com.example.knowhow

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.knowhow.ui.Message

//
// Created by Aydin Kubilay on 7.04.2023.
// Copyright (c) 2023 Sisal. All rights reserved.
//



@Composable
fun MessageCardMultipleText(msg: Message) {
    Text(text = msg.author)
    Text(text = msg.body)
}

@Composable
fun MessageCardColumn(msg: Message) {
    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}

@Composable
fun MessageCardProfile(msg: Message) {
    Row {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Contact profile picture",
        )
        MessageCardColumn(msg)
    }
}

@Composable
fun MessageCardModified(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun MessageCardCustomDesign(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember {
            mutableStateOf(false)
        }

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCardCustomDesign(message)
        }
    }
}

@Composable
fun ConversationClickable(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}
val message = Message("Kubilay","Hello Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose Jetpack Compose")
val messages = listOf(
    Message("Alice", "Hey, have you seen the new movie that just came out?"),
    Message("Bob", "No, I haven't. What's it called?"),
    Message("Alice", "It's called 'The Invisible Man'. It's supposed to be really good!"),
    Message("Charlie", "Hey guys, did you hear about the new restaurant that just opened up downtown?"),
    Message("David", "No, what kind of food do they serve?"),
    Message("Charlie", "It's a Mediterranean place. They have amazing hummus!"),
    Message("Emma", "Hey, I'm having a party this weekend. You guys should come!"),
    Message("Frank", "Sounds fun! What should we bring?"),
    Message("Emma", "Just bring yourselves! And maybe some drinks if you want."),
    Message("Henry", "Hey, did you guys hear about the new video game that just came out?"),
    Message("Isabelle", "No, what's it called?"),
    Message("Henry", "It's called 'Cyberpunk 2077'. It's supposed to be amazing!"),
    Message("Jack", "Hey, have you guys ever been skydiving before?"),
    Message("Alice", "No way, that sounds terrifying!"),
    Message("Bob", "I've never been, but I've always wanted to try it."),
    Message("Charlie", "I've been once before, and it was amazing!"),
    Message("David", "I don't think I have the guts to try it."),
    Message("Emma", "Hey, did you guys hear about the new art exhibit at the museum?"),
    Message("Frank", "No, what kind of art is it?"),
    Message("Emma", "It's a collection of abstract paintings. They're really cool!"),
    Message("Henry", "Hey, have you guys seen the new Star Wars movie yet?"),
    Message("Isabelle", "No, I haven't. Is it any good?"),
    Message("Henry", "It's amazing! You have to go see it!"),
    Message("Jack", "Hey, have you guys ever tried bungee jumping?"),
    Message("Alice", "No way, that's even more terrifying than skydiving!"),
    Message("Bob", "I've never tried it, but I think it would be really fun."),
    Message("Charlie", "I've done it once before, and it was an incredible rush!"),
    Message("David", "I don't think I could handle the fear."),
    Message("Emma", "Hey, have you guys heard about the new escape room that just opened up?"),
    Message("Frank", "No, what kind of puzzles do they have?"),
    Message("Emma", "It's a spy-themed room. You have to solve clues to stop a terrorist attack!"),
    Message("Henry", "Hey, have you guys ever gone whitewater rafting before?"),
    Message("Isabelle", "No, but it sounds like it would be a lot of fun!"),
    Message("Henry", "It's an incredible experience! You should definitely try it!"),
    Message("Jack", "Hey, have you guys ever gone camping in the mountains?"),
    Message("Alice", "No, but that sounds like it would be really peaceful."),
    Message("Bob", "I've gone camping in the mountains before, and it was amazing!"))