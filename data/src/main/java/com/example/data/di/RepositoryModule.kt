package com.example.data.di

import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

	@Binds
	fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
}