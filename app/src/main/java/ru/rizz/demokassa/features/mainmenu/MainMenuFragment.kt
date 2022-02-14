package ru.rizz.demokassa.features.mainmenu

import androidx.fragment.app.*
import dagger.hilt.android.*
import ru.rizz.demokassa.R
import ru.rizz.demokassa.databinding.*
import ru.rizz.demokassa.features.common.*
import ru.rizz.demokassa.features.mainmenu.MainMenuVM.*

@AndroidEntryPoint
class MainMenuFragment : FragmentBase<MainMenuVM, Event, ScreenMainMenuBinding>() {

	override val layoutId = R.layout.screen_main_menu
	override val vm by viewModels<MainMenuVM>()

	override fun onEvent(ev: Event) = when (ev) {
		else -> {}
	}
}