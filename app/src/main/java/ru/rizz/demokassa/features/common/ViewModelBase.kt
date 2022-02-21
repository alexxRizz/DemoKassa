package ru.rizz.demokassa.features.common

import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import ru.rizz.demokassa.features.topbar.*

abstract class ViewModelBase : ViewModel() {

	val topBarVM = TopBarVM().apply { onBackClick = ::onBackClick }

	private val mEventChannel = Channel<IVmEvent>(Channel.BUFFERED)
	val eventsFlow = mEventChannel.receiveAsFlow()

	protected open fun onBackClick() {}

	protected fun sendEvent(ev: IVmEvent) {
		viewModelScope.launch {
			mEventChannel.send(ev)
		}
	}
}