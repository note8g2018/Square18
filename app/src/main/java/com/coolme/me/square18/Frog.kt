package com.coolme.me.square18

import io.realm.RealmObject

class Frog : RealmObject {
    var name: String = ""
    var age: Int = 0
    var species: String? = null
    var owner: String? = null
}
