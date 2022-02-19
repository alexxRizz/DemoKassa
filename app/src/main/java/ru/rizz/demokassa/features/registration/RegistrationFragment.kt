package ru.rizz.demokassa.features.registration

import androidx.fragment.app.*
import dagger.hilt.android.*
import ru.rizz.demokassa.R
import ru.rizz.demokassa.databinding.*
import ru.rizz.demokassa.features.registration.RegistrationVM.*
import ru.rizz.demokassa.ui.*

@AndroidEntryPoint
class RegistrationFragment : FragmentBase<RegistrationVM, Event, ScreenRegistrationBinding>() {

	override val layoutId = R.layout.screen_registration
	override val vm by viewModels<RegistrationVM>()

	override fun onViewCreated() {
	}

	override fun onEvent(ev: Event) = when (ev) {
		Event.ExitFromRegistrationClicked -> screens.showMainMenu()
	}
}