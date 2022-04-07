package com.example.multimodulecomposemodeltest

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactor.ObserveUserUseCase
import com.example.domain.interactor.SetUserUseCase
import com.example.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@Stable
data class UserUiState(
	val user: User = User("1")
)

@HiltViewModel
class MainViewModel @Inject constructor(
	observeUserUseCase: ObserveUserUseCase,
	private val setUserUseCase: SetUserUseCase
) : ViewModel() {

	val user = observeUserUseCase()
		.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), User("1"))

	val wrappedUser = observeUserUseCase()
		.map(::UserUiState)
		.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UserUiState())

	private val _otherState: MutableStateFlow<Int> = MutableStateFlow(0)
	val otherState: StateFlow<Int> = _otherState

	fun onButtonClick() {
		viewModelScope.launch {
			setUserUseCase()
		}
	}

	fun onOtherAction() {
		_otherState.update {
			it + 1
		}
	}
}