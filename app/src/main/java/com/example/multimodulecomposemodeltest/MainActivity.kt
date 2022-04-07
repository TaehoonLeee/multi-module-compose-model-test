package com.example.multimodulecomposemodeltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			val viewModel: MainViewModel = viewModel()
			val otherState by viewModel.otherState.collectAsState()
			val userState by viewModel.wrappedUser.collectAsState()
			val user by viewModel.user.collectAsState()

			Column(
				modifier = Modifier.fillMaxSize(),
				verticalArrangement = Arrangement.SpaceBetween
			) {
				UserProfile(user)
				WrappedUserProfile(userUiState = userState)
				Button(viewModel::onButtonClick) {
					Text(text = "Set User")
				}
				OtherContent(otherState = otherState)
				Button(viewModel::onOtherAction) {
					Text(text = "Other Action")
				}
			}
		}
	}
}

@Composable
fun UserProfile(user: User) {
	println("test")
	Text(text = user.name)
}

@Composable
fun WrappedUserProfile(userUiState: UserUiState) {
	println("test2")
	Text(text = userUiState.user.name)
}

@Composable
fun OtherContent(otherState: Int) {
	println("test3")
	Text(text = otherState.toString())
}