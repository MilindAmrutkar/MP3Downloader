package com.backtocoding.mp3downloader.screens.initial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitialScreenComposable(viewModel: InitialScreenViewModel, onDownloadClicked: (String) -> Unit, onFolderSelectionClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // YouTube link EditText
        var youtubeLink by remember { mutableStateOf("") }
        OutlinedTextField(
            value = youtubeLink,
            onValueChange = { youtubeLink = it },
            label = { Text("YouTube link") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button for destination folder selection
        Button(onClick = { onFolderSelectionClicked() }) {
            Text("Select Destination Folder")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Text with info icon on left and text on right
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.Info, contentDescription = "Info")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Where you want to save the MP3")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Download button
        Button(
            onClick = { onDownloadClicked(youtubeLink) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Download")
        }
    }
}
