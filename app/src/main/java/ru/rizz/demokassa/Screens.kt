package ru.rizz.demokassa

import ru.rizz.demokassa.navigation.*
import javax.inject.*

class Screens @Inject constructor(
	private val mFragmentFactory: FragmentFactory,
	private val mFragmentContainer: FragmentContainer
) {

	fun registration() {
		mFragmentContainer.clear()
		mFragmentContainer.push(mFragmentFactory.registration())
	}
}