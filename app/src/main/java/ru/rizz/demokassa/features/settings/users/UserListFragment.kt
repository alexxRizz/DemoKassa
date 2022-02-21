package ru.rizz.demokassa.features.settings.users

import androidx.fragment.app.*
import dagger.hilt.android.*
import ru.rizz.demokassa.R
import ru.rizz.demokassa.databinding.*
import ru.rizz.demokassa.features.settings.users.UserListVM.*
import ru.rizz.demokassa.ui.*

@AndroidEntryPoint
class UserListFragment : FragmentBase<UserListVM, Event, ScreenUserListBinding>() {

	override val layoutId = R.layout.screen_user_list
	override val vm by viewModels<UserListVM>()

	override fun onViewCreated() {
		vm.usersVM.observe {
			binding.recycler.adapter = UserListAdapter(it, vm::onUserClick)
		}
		vm.onCreate()
	}

	override fun onEvent(ev: Event) = when (ev) {
		Event.BackClicked -> screens.back()
		Event.AddClicked -> screens.showUserEditor(null)
		is Event.UserClicked -> screens.showUserEditor(ev.user)
	}
}