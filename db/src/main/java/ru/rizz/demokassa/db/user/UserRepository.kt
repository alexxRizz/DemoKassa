package ru.rizz.demokassa.db.user

import ru.rizz.demokassa.model.*
import ru.rizz.demokassa.model.repositories.*
import javax.inject.*

class UserRepository @Inject constructor(
	private val mUserDao: UserDao
) : IUserRepository {

	override suspend fun count() =
		mUserDao.count()

	override suspend fun all(): List<User> {
		TODO("Not yet implemented")
	}
}