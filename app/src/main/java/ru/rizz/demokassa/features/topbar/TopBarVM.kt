package ru.rizz.demokassa.features.topbar

import androidx.lifecycle.*

class TopBarVM {
	val isVisible = MutableLiveData(true)
	val title = MutableLiveData("")
	val showBackButton = MutableLiveData(false)
	var onBackClick: () -> Unit = {}
}