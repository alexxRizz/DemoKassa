package ru.rizz.demokassa.features.mainmenu

import androidx.annotation.*

class MainMenu(
	val type: Type,
	val title: String,
	val items: List<MainMenuItem>,
) {
	enum class Type {
		Root,
		Refund,
	}
}

class MainMenuItem(
	@get:DrawableRes val image: Int,
	val text: String,
	val onClick: () -> Unit
)