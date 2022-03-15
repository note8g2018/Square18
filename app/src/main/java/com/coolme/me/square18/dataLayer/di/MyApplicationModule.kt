package com.coolme.me.square18.dataLayer.di

import com.coolme.me.square18.dataLayer.network.RegistrationNetworkImpl
import com.coolme.me.square18.dataLayer.repository.RegistrationRepositoryImpl
import com.coolme.me.square18.dataLayer.userInterface.RegistrationNetwork
import com.coolme.me.square18.dataLayer.userInterface.RegistrationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MyApplicationModule
{
    @Binds
    abstract fun bindRegistrationRepository(
        registrationRepositoryImpl: RegistrationRepositoryImpl
                                           ): RegistrationRepository

    @Binds
    abstract fun bindRegistrationNetwork(
        registrationNetworkImpl: RegistrationNetworkImpl
                                           ): RegistrationNetwork

}