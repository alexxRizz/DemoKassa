package ru.rizz.demokassa.ui

import androidx.fragment.app.*
import ru.rizz.demokassa.features.mainmenu.*
import ru.rizz.demokassa.ui.navigation.FragmentContainer
import ru.rizz.demokassa.ui.navigation.FragmentFactory
import javax.inject.*

class Screens @Inject constructor(
	private val mFragmentFactory: FragmentFactory,
	private val mFragmentContainer: FragmentContainer,
) {

	fun showRegistration() =
		clearAndPush(mFragmentFactory.registration())

	fun showMainMenu(menuType: MainMenu.Type = MainMenu.Type.Root) =
		mFragmentFactory.mainMenu(menuType).let {
			if (menuType == MainMenu.Type.Root)
				clearAndPush(it) else
				push(it)
		}

	private fun clearAndPush(fragment: Fragment) =
		with(mFragmentContainer) {
			clear()
			push(fragment)
		}

	private fun push(fragment: Fragment) =
		mFragmentContainer.push(fragment)

	fun back() {
		mFragmentContainer.pop()
	}
}