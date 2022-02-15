package ru.rizz.demokassa.db.user

import ru.rizz.demokassa.db.user.UserMapper.asDomain
import ru.rizz.demokassa.db.user.UserMapper.asRow
import ru.rizz.demokassa.model.*
import ru.rizz.demokassa.model.repositories.*
import javax.inject.*

@Singleton
internal class UserRepository @Inject constructor(
	private val mDao: UserDao
) : IUserRepository {

	override suspend fun count() =
		mDao.count()

	override suspend fun all() =
		mDao.all().map { it.asDomain() }

	override suspend fun add(user: User) =
		mDao.insert(user.asRow())
}