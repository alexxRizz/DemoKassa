package ru.rizz.demokassa.db.di

import android.content.*
import androidx.room.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.components.*
import ru.rizz.demokassa.db.*
import javax.inject.*

@Module
@InstallIn(SingletonComponent::class)
internal class DbModule {

	@Singleton
	@Provides
	fun db(@ApplicationContext context: Context) =
		Room.databaseBuilder(context, MainDatabase::class.java, "main.sqlite")
			//.addMigrations(*Migrations.getAll())
			.build()

	@Provides
	fun users(db: MainDatabase) = db.users()
}