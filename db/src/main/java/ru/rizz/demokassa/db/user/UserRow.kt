package ru.rizz.demokassa.db.user

import androidx.room.*

@Entity(tableName = "users")
internal data class UserRow(
	@PrimaryKey
	@ColumnInfo(collate = ColumnInfo.NOCASE)
	val id: String,

	val name: String,
	val password: String,
	val isAdmin: Boolean,
)