package ru.rizz.demokassa.di

import dagger.*
import dagger.hilt.*
import dagger.hilt.components.*
import ru.rizz.demokassa.db.user.*
import ru.rizz.demokassa.model.repositories.*

@Module
@InstallIn(SingletonComponent::class)
interface DbRepositoryModule {

	@Binds
	fun users(value: UserRepository): IUserRepository
}