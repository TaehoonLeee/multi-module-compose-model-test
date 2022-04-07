package com.example.domain.repository

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
	fun observeUser(): Flow<User>
	suspend fun setUser()
}