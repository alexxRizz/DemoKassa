package ru.rizz.demokassa.features.mainmenu

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.*
import ru.rizz.demokassa.features.common.*
import javax.inject.*

@HiltViewModel
class MainMenuVM @Inject constructor() : ViewModelBase() {

	sealed class Event : IVmEvent {
		object BackClicked : Event()
		data class ToastRequested(val text: String) : Event()
		object SellClicked : Event()
		object SettingsClicked : Event()
		data class SubmenuClicked(val menuType: MainMenu.Type) : Event()
		object RefundNoChequeClicked : Event()
		object RefundWithChequeNumberClicked : Event()
		object RefundWithChequeQrCodeClicked : Event()
	}

	private val mItems get() = menuVM.value!!.items
	private lateinit var mMenuFactory: MainMenuFactory

	val menuVM = MutableLiveData<MainMenu>()
	val titleVM = menuVM.map { it.title }
	val showBackButtonVM = menuVM.map { it.type != MainMenu.Type.Root }

	fun onCreate(menuType: MainMenu.Type) {
		mMenuFactory = MainMenuFactory(::sendEvent)
		menuVM.value = mMenuFactory.new(menuType)
	}

	fun onBack() =
		sendEvent(Event.BackClicked)

	fun onItemClick(pos: Int) =
		mItems[pos].onClick()
}