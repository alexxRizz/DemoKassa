package ru.rizz.demokassa.ui

import androidx.fragment.app.*
import ru.rizz.demokassa.features.mainmenu.*
import ru.rizz.demokassa.features.settings.users.*
import ru.rizz.demokassa.model.*
import ru.rizz.demokassa.ui.navigation.FragmentContainer
import ru.rizz.demokassa.ui.navigation.FragmentFactory
import javax.inject.*

class Screens @Inject constructor(
	private val mFragmentFactory: FragmentFactory,
	private val mFragmentContainer: FragmentContainer,
) {

	fun back() =
		pop()

	fun showRegistration() =
		clearAndPush(mFragmentFactory.registration())

	fun showMainMenu(menuType: MainMenu.Type = MainMenu.Type.Root) =
		mFragmentFactory.mainMenu(menuType).let {
			if (menuType == MainMenu.Type.Root)
				clearAndPush(it) else
				push(it)
		}

	fun showUserList() =
		push(UserListFragment())

	fun showUserEditor(@Suppress("UNUSED_PARAMETER") user: User?) {
		// TODO
	}

	private fun clearAndPush(fragment: Fragment) =
		with(mFragmentContainer) {
			clear()
			push(fragment)
		}

	private fun push(fragment: Fragment) =
		mFragmentContainer.push(fragment)

	private fun pop() =
		mFragmentContainer.pop()
}