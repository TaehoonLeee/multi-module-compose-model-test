package com.example.data.di

import com.example.data.network.UserApiExecutor
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//	@Provides
//	@Singleton
//	fun provideUserApiExecutor() = UserApiExecutor()
//}

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

	@Binds
	fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
}