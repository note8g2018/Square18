package com.coolme.me.square18.dataLayer.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
class UserRealm : RealmObject
{
    var token: String = ""
    var _id : String = ""
    @PrimaryKey
    var username:String = ""
    var email: String = ""
    var idNumber: Int = 0
    var ip: String = ""
    var disabled: Boolean = false
    var isLogin: Boolean = false
    var lastTimeLoginUTC : String = ""
    var createdAt : String = ""
    var updatedAt: String = ""
}