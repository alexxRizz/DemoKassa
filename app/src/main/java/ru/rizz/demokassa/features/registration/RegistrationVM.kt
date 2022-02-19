package ru.rizz.demokassa.features.registration

import dagger.hilt.android.lifecycle.*
import ru.rizz.demokassa.features.common.*
import javax.inject.*

@HiltViewModel
class RegistrationVM @Inject constructor() : ViewModelBase() {

	sealed class Event : IVmEvent {
		object ExitFromRegistrationClicked : Event()
	}

	fun onExitFromRegistration() {
		sendEvent(Event.ExitFromRegistrationClicked)
	}
}