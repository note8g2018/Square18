package com.coolme.me.square18.dataLayer.userInterface

import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.dataLayer.model.UserRealm

interface LocalDatabase
{
    fun saveOrUpdateUser(user: User)

    fun getUserRealm(username: String): UserRealm?

    fun getUserRealm(): UserRealm?

    fun getUser(): User?

    fun deleteUser(user: User)
}