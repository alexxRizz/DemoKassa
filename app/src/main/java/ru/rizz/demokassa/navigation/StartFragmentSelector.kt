package ru.rizz.demokassa.navigation

import ru.rizz.demokassa.model.repositories.*
import javax.inject.*

class StartFragmentSelector @Inject constructor(
	private val mFragmentFactory: FragmentFactory,
	private val mFragmentContainer: FragmentContainer,
	private val mUserRepository: IUserRepository
) : IStartFragmentSelector {

	override suspend operator fun invoke() {
		mFragmentContainer.push(getFragment())
	}

	private suspend fun getFragment() =
		if (mUserRepository.count() == 0)
			mFragmentFactory.registration() else
			mFragmentFactory.login()
}