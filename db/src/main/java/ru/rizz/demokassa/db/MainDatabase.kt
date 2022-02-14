package ru.rizz.demokassa.db

import androidx.room.*
import ru.rizz.demokassa.db.user.*

@Database(
	version = BuildConfig.DATABASE_VERSION_CODE,
	exportSchema = false,
	entities = arrayOf(
		UserRow::class
	)
)
abstract class MainDatabase : RoomDatabase() {

	abstract fun users(): UserDao
}