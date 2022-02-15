package ru.rizz.demokassa.model.repositories

import ru.rizz.demokassa.model.*

interface IUserRepositoryReadOnly {

	suspend fun count(): Int
	suspend fun all(): List<User>
}

interface IUserRepository : IUserRepositoryReadOnly {

	suspend fun add(user: User)
}