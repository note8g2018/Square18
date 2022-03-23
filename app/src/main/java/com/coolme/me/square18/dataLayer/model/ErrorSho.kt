package com.coolme.me.square18.dataLayer.model

import javax.inject.Inject

data class ErrorSho @Inject constructor(
    val error : Boolean,
    val statusCode : Int,
    val message : String,
    val title : String? = null,
    val type: String?,
                                  )
  //  : Exception()
