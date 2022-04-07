package com.example.data.repository

import com.example.data.network.UserApiExecutor
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
	private val userApiExecutor: UserApiExecutor
) : UserRepository {

	override fun observeUser(): Flow<User> = userApiExecutor.user

	override suspend fun setUser() = userApiExecutor.setUser()
}