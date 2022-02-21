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

	fun onCreate(menuType: MainMenu.Type) {
		mMenuFactory = MainMenuFactory(::sendEvent)
		val menu = mMenuFactory.new(menuType)
		topBarVM.title.value = menu.title
		topBarVM.showBackButton.value = menu.type != MainMenu.Type.Root
		menuVM.value = menu
	}

	override fun onBackClick() =
		sendEvent(Event.BackClicked)

	fun onItemClick(pos: Int) =
		mItems[pos].onClick()
}