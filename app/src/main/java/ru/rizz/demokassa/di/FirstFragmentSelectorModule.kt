package ru.rizz.demokassa.di

import dagger.*
import dagger.hilt.*
import dagger.hilt.android.components.*
import ru.rizz.demokassa.navigation.*

@Module
@InstallIn(ActivityComponent::class)
interface FirstFragmentSelectorModule {

	@Binds
	fun startFragmentSelector(value: StartFragmentSelector): IStartFragmentSelector
}