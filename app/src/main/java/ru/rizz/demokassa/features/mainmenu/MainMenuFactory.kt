package ru.rizz.demokassa.features.mainmenu

import ru.rizz.demokassa.*
import ru.rizz.demokassa.features.mainmenu.MainMenuVM.*

class MainMenuFactory constructor(
	private val sendEvent: ISendEvent
) {
	fun interface ISendEvent : (Event) -> Unit

	private val mMenuMap = listOf(rootMenu(), refundMenu()).associateBy { it.type }

	fun new(type: MainMenu.Type) =
		mMenuMap[type] ?: throw RuntimeException("Unknown menu type: $type")

	private fun rootMenu() = MainMenu(
		MainMenu.Type.Root, "Главное меню", listOf(
			MainMenuItem(R.drawable.ic_sell, "Продажа") { sendEvent(Event.SellClicked) },
			MainMenuItem(R.drawable.ic_refund, "Возврат") { sendEvent(Event.SubmenuClicked(MainMenu.Type.Refund)) },
			MainMenuItem(R.drawable.ic_settings, "Настройки") { sendEvent(Event.SettingsClicked) },
		))

	private fun refundMenu() = MainMenu(
		MainMenu.Type.Refund, "Возврат", listOf(
			MainMenuItem(R.drawable.ic_refund, "Возврат без чека") { sendEvent(Event.RefundNoChequeClicked) },
			MainMenuItem(R.drawable.ic_refund, "Возврат по номеру чека") { sendEvent(Event.RefundWithChequeNumberClicked) },
			MainMenuItem(R.drawable.ic_refund, "Возврат по qr-коду чека") { sendEvent(Event.RefundWithChequeQrCodeClicked) },
		))
}