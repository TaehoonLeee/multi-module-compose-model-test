package com.example.data.network

import com.example.domain.model.User
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserApiExecutor @Inject constructor() {

	private val _user: MutableSharedFlow<User> = MutableSharedFlow()
	val user: SharedFlow<User> get() = _user

	var cnt = 2
	suspend fun setUser() {
		_user.emit(User(cnt++.toString()))
	}
}