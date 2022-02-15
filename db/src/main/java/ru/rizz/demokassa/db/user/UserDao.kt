package ru.rizz.demokassa.db.user

import androidx.room.*

@Dao
internal interface UserDao {

	@Query("SELECT COUNT(1) FROM users")
	suspend fun count(): Int

	@Query("SELECT * FROM users ORDER BY name, id")
	suspend fun all(): List<UserRow>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(row: UserRow)

	@Delete
	fun delete(row: UserRow)
}