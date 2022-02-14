package ru.rizz.demokassa.features.mainmenu

import dagger.hilt.android.lifecycle.*
import ru.rizz.demokassa.features.common.*
import javax.inject.*

@HiltViewModel
class MainMenuVM @Inject constructor() : ViewModelBase() {

	sealed class Event : IVmEvent
}