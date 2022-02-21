package ru.rizz.demokassa.features.settings.users

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.*
import kotlinx.coroutines.*
import ru.rizz.demokassa.features.common.*
import ru.rizz.demokassa.model.*
import ru.rizz.demokassa.model.repositories.*
import javax.inject.*

@HiltViewModel
class UserListVM @Inject constructor(
	private val mUserRepository: IUserRepository
) : ViewModelBase() {

	sealed class Event : IVmEvent {
		object BackClicked : Event()
		object AddClicked : Event()
		data class UserClicked(val user: User) : Event()
	}

	private val mUsers get() = usersVM.value!!

	val usersVM = MutableLiveData(listOf<User>())
	val isEmptyVM = usersVM.map { it.isEmpty() }

	fun onCreate() {
		topBarVM.title.value = "Пользователи"
		viewModelScope.launch {
			usersVM.value = mUserRepository.all()
		}
	}

	override fun onBackClick() =
		sendEvent(Event.BackClicked)

	fun onUserClick(pos: Int) {
		sendEvent(Event.UserClicked(mUsers[pos]))
	}

	fun onAddClick() {
		sendEvent(Event.AddClicked)
	}
}