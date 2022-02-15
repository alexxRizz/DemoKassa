package ru.rizz.demokassa.db.user

import ru.rizz.demokassa.model.*

internal object UserMapper {
	fun UserRow.asDomain() = User(id, name, password, isAdmin)
	fun User.asRow() = UserRow(id, name, password, isAdmin)
}