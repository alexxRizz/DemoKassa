package ru.rizz.demokassa.navigation

import androidx.fragment.app.*
import ru.rizz.demokassa.features.login.*
import ru.rizz.demokassa.features.registration.*
import javax.inject.*

class FragmentFactory @Inject constructor() {

	fun login(): Fragment = LoginFragment()

	fun registration(): Fragment = RegistrationFragment()
}