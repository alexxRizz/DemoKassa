package ru.rizz.demokassa.ui.navigation

import ru.rizz.demokassa.model.repositories.*
import ru.rizz.demokassa.ui.*
import javax.inject.*

class StartFragmentSelector @Inject constructor(
	private val mScreen: Screens,
	private val mUserRepository: IUserRepositoryReadOnly,
) : IStartFragmentSelector {

	override suspend operator fun invoke() {
		if (mUserRepository.count() == 0)
			mScreen.showMainMenu() else
			mScreen.showRegistration()
	}
}