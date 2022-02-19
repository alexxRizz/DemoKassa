package ru.rizz.demokassa.ui.navigation

import android.content.*
import androidx.annotation.*
import androidx.fragment.app.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.android.scopes.*
import ru.rizz.demokassa.*
import javax.inject.*


/** Необходимо помнить, что перед commit'ом любой тр-ции следует вызывать setReorderingAllowed().
 *
 * https://developer.android.com/guide/fragments/transactions#reordering
 * "Enabling the flag ensures that if multiple transactions are executed together,
 * any intermediate fragments (i.e. ones that are added and then immediately replaced)
 * do not go through lifecycle changes or have their animations or transitions executed."
 *
 * https://developer.android.com/guide/fragments/fragmentmanager#perform
 * "setReorderingAllowed(true) optimizes the state changes of the fragments involved in the transaction so that animations and transitions work correctly."
 * @see FragmentTransaction.setReorderingAllowed
 **/
@ActivityScoped
class FragmentContainer @Inject constructor(
	@ActivityContext activityContext: Context
) {

	companion object {
		@IdRes private val mFragmentContainerId = R.id.fragment_container
	}

	private val mActivity = activityContext as FragmentActivity
	private val mFragmentManager get() = mActivity.supportFragmentManager

	fun push(fragment: Fragment) {
		mFragmentManager.commit {
			setReorderingAllowed(true)
			replace(mFragmentContainerId, fragment)
			addToBackStack(fragment.javaClass.name)
		}
	}

	fun pop() {
		if (mFragmentManager.backStackEntryCount > 1)
			mFragmentManager.popBackStack()
		// Если остался 1 фрагмент, то намеренно не выходим из приложения,
		// т.к. это стандартная практика для kiosk-mode приложений.
	}

	//	fun <T : Fragment> popTo(fragmentType: Class<T>) {
	//		mFragmentManager.popBackStack(fragmentType.name, 0)
	//	}

	fun clear() {
		repeat(mFragmentManager.backStackEntryCount) {
			mFragmentManager.popBackStack()
		}
	}
}
