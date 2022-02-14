package ru.rizz.demokassa.features.common

import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*

abstract class ViewModelBase : ViewModel() {

	private val mEventChannel = Channel<IVmEvent>(Channel.BUFFERED)
	val eventsFlow = mEventChannel.receiveAsFlow()

	protected fun sendEvent(ev: IVmEvent) {
		viewModelScope.launch {
			mEventChannel.send(ev)
		}
	}
}