package com.example.multimodulecomposemodeltest

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun Counter() {
	var count by remember { mutableStateOf(0) }
	Button(
		onClick = { count += 1 }
	) {
		Text(text = "Count : $count")
	}
}