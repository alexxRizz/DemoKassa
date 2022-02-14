package ru.rizz.demokassa.db.user

import androidx.room.*

@Dao
interface UserDao {

	@Query("SELECT COUNT(1) FROM users")
	suspend fun count(): Int
}