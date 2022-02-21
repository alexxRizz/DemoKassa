package ru.rizz.demokassa.model

import java.io.*

data class User(
	val id: String,
	val name: String,
	val password: String,
	val isAdmin: Boolean,
) : Serializable