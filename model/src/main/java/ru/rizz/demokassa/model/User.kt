package ru.rizz.demokassa.model

data class User(
	val id: String,
	val name: String,
	val password: String,
	val isAdmin: Boolean,
)