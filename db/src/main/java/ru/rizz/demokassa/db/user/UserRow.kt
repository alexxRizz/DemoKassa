package ru.rizz.demokassa.db.user

import androidx.room.*

@Entity(tableName = "users")
class UserRow {

	@ColumnInfo(collate = ColumnInfo.NOCASE, name = "code")
	@PrimaryKey
	var code: String = ""
}