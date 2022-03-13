package com.coolme.me.square18.dataLayer.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import javax.inject.Inject

@Serializable
data class User @Inject constructor(
    var token: String? = null,
    var _id : String,
    var username:String,
    var email: String,
    var idNumber: Int,
    var ip: String,
    var disabled: Boolean? = null,
    var isLogin: Boolean,
    var lastTimeLoginUTC : Instant,
    var createdAt : Instant,
    var updatedAt: Instant,
               )
