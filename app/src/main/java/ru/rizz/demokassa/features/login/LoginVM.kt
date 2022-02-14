package ru.rizz.demokassa.features.login

import dagger.hilt.android.lifecycle.*
import ru.rizz.demokassa.features.common.*
import ru.rizz.demokassa.model.repositories.*
import javax.inject.*

@HiltViewModel
class LoginVM @Inject constructor(
	private val mUserRepository: IUserRepository
) : ViewModelBase() {

	sealed class Event : IVmEvent {
		object UserSelected : Event()
	}

	fun onClick() {
		sendEvent(Event.UserSelected)
	}
}