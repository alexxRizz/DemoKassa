package ru.rizz.demokassa.features.login

import androidx.fragment.app.*
import dagger.hilt.android.*
import ru.rizz.demokassa.R
import ru.rizz.demokassa.databinding.*
import ru.rizz.demokassa.features.login.LoginVM.*
import ru.rizz.demokassa.ui.*

@AndroidEntryPoint
class LoginFragment : FragmentBase<LoginVM, Event, ScreenLoginBinding>() {

	override val layoutId = R.layout.screen_login
	override val vm by viewModels<LoginVM>()

	override fun onViewCreated() {
	}

	override fun onEvent(ev: Event) = when (ev) {
		Event.UserSelected -> screens.showRegistration()
	}
}