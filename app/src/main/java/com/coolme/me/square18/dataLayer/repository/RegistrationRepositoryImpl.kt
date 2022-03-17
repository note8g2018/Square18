package com.coolme.me.square18.dataLayer.repository

import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.dataLayer.userInterface.RegistrationNetwork
import com.coolme.me.square18.dataLayer.userInterface.RegistrationRepository
import com.coolme.me.square18.domainLayer.registration.RegistrationUiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val registrationNetwork: RegistrationNetwork,
    //@ApplicationContext private val applicationContext: Context,
                                                    ) : RegistrationRepository
{
    override suspend fun submit(registrationUiState: RegistrationUiState)
    : Flow<ResultSho<User>>
    {
//        val constraints: Constraints = Constraints.Builder()
//                .setRequiredNetworkType(NetworkType.CONNECTED)
//                .build()
//
//        val jsonString = Json.encodeToString(
//            serializer = RegistrationUiState.serializer(),
//            value = registrationUiState)
//
//        val inputData : Data =
//            workDataOf("regJson" to jsonString)
//
//        val registrationExpeditedWorkerRequest: OneTimeWorkRequest =
//            OneTimeWorkRequestBuilder<RegistrationExpeditedWorker>()
//                    .addTag("reg")
//                    .setConstraints(constraints)
//                    .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
//                    .setInputData(inputData)
//                    .build()
//
//        val registrationWorkManager = WorkManager.getInstance(applicationContext)
//
//        registrationWorkManager.enqueueUniqueWork(
//                    "reg",
//                    ExistingWorkPolicy.KEEP,
//                    registrationExpeditedWorkerRequest,
//                                  )



        //******** should delete down
        return registrationNetwork.registerUser(registrationUiState)
    }
}