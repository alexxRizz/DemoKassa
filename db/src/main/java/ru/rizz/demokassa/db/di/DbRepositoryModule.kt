package ru.rizz.demokassa.db.di

import dagger.*
import dagger.hilt.*
import dagger.hilt.components.*
import ru.rizz.demokassa.db.user.*
import ru.rizz.demokassa.model.repositories.*

@Module
@InstallIn(SingletonComponent::class)
internal interface DbRepositoryModule {

	@Binds
	fun users(value: UserRepository): IUserRepository

	@Binds
	fun usersReadOnly(value: UserRepository): IUserRepositoryReadOnly
}