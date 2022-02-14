package ru.rizz.demokassa.model.repositories

import ru.rizz.demokassa.model.*

interface IUserRepository {

	suspend fun count(): Int
	suspend fun all(): List<User>
}