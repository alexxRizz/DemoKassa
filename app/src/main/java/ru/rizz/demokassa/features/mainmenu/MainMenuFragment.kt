package ru.rizz.demokassa.features.mainmenu

import androidx.fragment.app.*
import dagger.hilt.android.*
import ru.rizz.demokassa.R
import ru.rizz.demokassa.databinding.*
import ru.rizz.demokassa.features.mainmenu.MainMenuVM.*
import ru.rizz.demokassa.ui.*

@AndroidEntryPoint
class MainMenuFragment : FragmentBase<MainMenuVM, Event, ScreenMainMenuBinding>() {

	companion object {
		const val BUNDLE_MENU_TYPE = "BUNDLE_MENU_TYPE"
	}

	override val layoutId = R.layout.screen_main_menu
	override val vm by viewModels<MainMenuVM>()

	override fun onViewCreated() {
		val menuType = requireArguments().getSerializable(BUNDLE_MENU_TYPE) as MainMenu.Type
		vm.menuVM.observe {
			binding.recycler.adapter = MainMenuAdapter(it.items, vm::onItemClick)
		}
		vm.onCreate(menuType)
	}

	override fun onEvent(ev: Event) = when (ev) {
		Event.BackClicked -> screens.back()
		is Event.ToastRequested -> viewService.showToast(ev.text)
		Event.SellClicked -> screens.showRegistration()
		is Event.SubmenuClicked -> screens.showMainMenu(ev.menuType)
		Event.SettingsClicked -> viewService.showToast("Настройки")
		Event.RefundNoChequeClicked -> viewService.showToast("Возврат без чека")
		Event.RefundWithChequeNumberClicked -> viewService.showToast("Возврат по номеру чека")
		Event.RefundWithChequeQrCodeClicked -> viewService.showToast("Возврат по qr-коду чека")
	}
}