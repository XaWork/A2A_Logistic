package a2a.logistic.app.di

import a2a.logistic.app.data.repository.AddUserRepositoryImpl
import a2a.logistic.app.data.repository.LoginRepositoryImpl
import a2a.logistic.app.data.repository.ManageUserRepositoryImpl
import a2a.logistic.app.domain.repository.AddUserRepository
import a2a.logistic.app.domain.repository.LoginRepository
import a2a.logistic.app.domain.repository.ManageUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository

    @Binds
    @Singleton
    abstract fun bindAddUserRepository(
        addUserRepositoryImpl: AddUserRepositoryImpl
    ): AddUserRepository

    @Binds
    @Singleton
    abstract fun bindManageUserRepository(
        manageUserRepositoryImpl: ManageUserRepositoryImpl
    ): ManageUserRepository
}