package com.coolme.me.square18.dataLayer.repository

import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.dataLayer.model.UserRealm
import com.coolme.me.square18.dataLayer.userInterface.RegistrationNetwork
import com.coolme.me.square18.dataLayer.userInterface.RegistrationRepository
import com.coolme.me.square18.domainLayer.registration.RegistrationUiState
import io.realm.Realm
import io.realm.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val registrationNetwork: RegistrationNetwork,
    //@ApplicationContext private val applicationContext: Context,
    private val userRealm: Realm,
                                                    ) : RegistrationRepository
{
    override suspend fun submit(registrationUiState: RegistrationUiState)
    : Flow<ResultSho<User>>
    {
        val result = registrationNetwork.registerUser(registrationUiState)
        return flow {
            result.collect{value ->

                when (value)
                {
                    is ResultSho.Failure     ->
                    {
                        emit(value)
                    }
                    is ResultSho.Progressing ->
                    {
                        emit(value)
                    }
                    is ResultSho.Success     ->
                    {
                        var user3 : UserRealm? = null
                        val job: Job = CoroutineScope(Dispatchers.IO).launch {
                            saveOrUpdate(value.data)
                            user3 = getUserRealm("qwert123")
                        }
                        job.join()
                        println(user3?.username)
                        println(user3?.email)
                        println(user3)
                        emit(value)
                    }
                }
            }
        }

    }

    private fun saveOrUpdate(user: User)
    {
        println(userRealm.configuration.path)
        userRealm.writeBlocking  {
            val userRealm: UserRealm? = this
                    .query<UserRealm>("username == $0", "qwert123")
                    .first().find()
            if(userRealm != null)
            {
                userRealm.token = user.token!!
                userRealm._id = user._id
                //userRealm.username = user.username
                userRealm.email = user.email
                userRealm.idNumber = user.idNumber
                userRealm.ip = user.ip
                userRealm.disabled = user.disabled!!
                userRealm.isLogin = user.isLogin
                userRealm.lastTimeLoginUTC = user.lastTimeLoginUTC.toString()
                userRealm.createdAt = user.createdAt.toString()
                userRealm.updatedAt = user.updatedAt.toString()
            }
            else
            {
                this.copyToRealm(user.toUserRealm())
            }
        }
    }

    private fun getUserRealm(username: String): UserRealm?
    {
        return userRealm
                .query<UserRealm>("username == $0", username)
                .first().find()
    }
}