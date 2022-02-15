package ru.rizz.demokassa.db

import androidx.room.*
import ru.rizz.demokassa.db.user.*

@Database(
	version = BuildConfig.DATABASE_VERSION_CODE,
	exportSchema = false,
	entities = [
		UserRow::class
	]
)
internal abstract class MainDatabase : RoomDatabase() {

	abstract fun users(): UserDao
}