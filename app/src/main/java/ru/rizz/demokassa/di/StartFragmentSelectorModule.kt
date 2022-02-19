package ru.rizz.demokassa.di

import dagger.*
import dagger.hilt.*
import dagger.hilt.android.components.*
import ru.rizz.demokassa.ui.navigation.*

@Module
@InstallIn(ActivityComponent::class)
interface StartFragmentSelectorModule {

	@Binds
	fun startFragmentSelector(value: StartFragmentSelector): IStartFragmentSelector
}