package com.example.domain.interactor

import com.example.domain.repository.UserRepository
import javax.inject.Inject

class ObserveUserUseCase @Inject constructor(
	private val userRepository: UserRepository
) {
	operator fun invoke() = userRepository.observeUser()
}