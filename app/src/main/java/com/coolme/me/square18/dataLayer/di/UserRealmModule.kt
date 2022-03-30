package com.coolme.me.square18.dataLayer.di

import com.coolme.me.square18.dataLayer.model.UserRealm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserRealmModule
{
    @Singleton
    @Provides
    fun provideUserRealm() : Realm
    {
        val config = RealmConfiguration
                .Builder(schema = setOf(UserRealm::class))
                .name("userRealm")
                .build()
        return Realm.open(config)
    }
}