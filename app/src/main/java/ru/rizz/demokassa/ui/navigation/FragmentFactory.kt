package ru.rizz.demokassa.ui.navigation

import androidx.core.os.*
import androidx.fragment.app.*
import ru.rizz.demokassa.features.login.*
import ru.rizz.demokassa.features.mainmenu.*
import ru.rizz.demokassa.features.registration.*
import javax.inject.*

class FragmentFactory @Inject constructor() {

	fun login(): Fragment = LoginFragment()

	fun registration(): Fragment = RegistrationFragment()

	fun mainMenu(menuType: MainMenu.Type): Fragment =
		MainMenuFragment().apply {
			arguments = bundleOf(MainMenuFragment.BUNDLE_MENU_TYPE to menuType)
		}
}